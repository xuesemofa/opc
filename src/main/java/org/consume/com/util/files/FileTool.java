package org.consume.com.util.files;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileTool {
    /**
     * 下载文件
     *
     * @param filePath --文件完整路径
     * @param response
     */
    public static void downloadFile(
            String filePath,
            javax.servlet.http.HttpServletResponse response) {


        String fileName = "";
        try {
            if (filePath.lastIndexOf("/") > 0) {
                fileName = new String(filePath.substring(filePath.lastIndexOf("/") + 1, filePath.length()).getBytes("GB2312"), "ISO8859_1");
            } else if (filePath.lastIndexOf("\\") > 0) {
                fileName = new String(filePath.substring(filePath.lastIndexOf("\\") + 1, filePath.length()).getBytes("GB2312"), "ISO8859_1");
            }

        } catch (Exception e) {
        }
        //打开指定文件的流信息
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        //设置响应头和保存文件名
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        //写出流信息
        int b = 0;
        try {
            PrintWriter out = response.getWriter();
            while ((b = fs.read()) != -1) {
                out.write(b);
            }
            fs.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param inputFileName 想要压缩的文件夹
     * @param targetFile    生成文件存放的位置
     */

    public static void Zip(String targetFile, String inputFileName) throws Exception {
        Zip(targetFile, new File(inputFileName));
    }

    public static void Zip(String zipFileName, File inputFile) throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        Zip(out, inputFile, "");
        out.close();
    }

    /**
     * @param out  要压缩到哪个目录下
     * @param f    要压缩的文件夹的路径
     * @param base 为顶层目录
     * @throws Exception
     */
    public static void Zip(ZipOutputStream out, File f, String base) throws Exception {
        if (f.isDirectory()) { //获取文件夹里面的所有数据
            File[] ary_f = f.listFiles();
            out.putNextEntry(new ZipEntry(base + "/"));
            base = base.length() == 0 ? "" : base + "/";
            if (ary_f != null && ary_f.length > 0) {
                for (int i = 0; i < ary_f.length; i++) {
                    Zip(out, ary_f[i], base + ary_f[i].getName());
                }
            }
        } else {
            out.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(f);
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
            in.close();
        }
    }

    /**
     * 复制单个文件
     *
     * @param oldPathFile 准备复制的文件源
     * @param newPathFile 拷贝到新绝对路径带文件名
     * @return
     */
    public static void copyFile(String oldPathFile, String newPathFile) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPathFile);
            if (oldfile.exists()) { //文件存在时
                InputStream inStream = new FileInputStream(oldPathFile); //读入原文件
                FileOutputStream fs = null;
                try {

                    fs = new FileOutputStream(newPathFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 新建目录
     *
     * @param folderPath 目录
     * @return 返回目录创建后的路径
     */
    public static void createFolder(String folderPath) {
        String txt = folderPath;
        try {
            File myFilePath = new File(txt);
            if (!myFilePath.exists()) {
                myFilePath.mkdir();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除空目录
     *
     * @param folderPath 目录
     * @return 返回目录创建后的路径
     */
    public static void deleteFolder(String folderPath) {
        String txt = folderPath;
        try {
            File myFilePath = new File(txt);
            if (myFilePath.exists()) {
                myFilePath.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将文件移动新的文件夹
     *
     * @param sourceFile
     * @param targetPath
     * @return --文件名
     */
    public static String moveFile(String sourceFile, String targetPath) {
        try {
            File oldFile = new File(sourceFile);
            //new一个新文件夹
            File fnewpath = new File(targetPath);
            //判断文件夹是否存在
            if (!fnewpath.exists())
                fnewpath.mkdirs();
            //将文件移到新文件里
            String oldFileName = oldFile.getName();
            String[] names = oldFileName.split("\\.");
            String name = names[0];
            String suffix = "";
            if (names.length > 1) {
                suffix = "." + names[1];
            }
            for (int i = 0; ; i++) {
                File file = new File(targetPath + name + String.valueOf(i) + suffix);
                if (!file.exists()) {
                    oldFileName = targetPath + name + String.valueOf(i) + suffix;
                    break;
                }
            }
            File fnew = new File(oldFileName);
            oldFile.renameTo(fnew);
            return oldFileName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    /**
     * 删除文件夹及文件夹下的文件
     *
     * @param folderPath 文件夹完整绝对路径
     */
    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); //删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            java.io.File myFilePath = new java.io.File(filePath);
            myFilePath.delete(); //删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 删除文件夹下的所有文件
     *
     * @param path 文件夹完整绝对路径
     */
    public static boolean delAllFile(String path) throws Exception {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
                delFolder(path + "/" + tempList[i]);//再删除空文件夹
                flag = true;
            }
        }
        return flag;
    }
}
