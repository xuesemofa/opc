package org.consume.com.util.resultJson;

public class Htmls {

    /**
     * 返回span标签的字符串
     *
     * @param color String
     * @param str   String
     * @return String
     */
    public static String SPAN(String color, String str) {
        return "<span style='color:" + color + ";'>" + str + "</span>";
    }
}
