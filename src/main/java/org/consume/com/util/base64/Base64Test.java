package org.consume.com.util.base64;

import java.text.SimpleDateFormat;

public class Base64Test {

    public static void main(String[] args) throws Exception{
        long oneStrat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-12-01 00:00:00").getTime();
        long oneEnd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-12-31 24:59:59").getTime();
        System.out.println(oneStrat);
        System.out.println(oneEnd);
    }
}
