package com.eports.design_pattern.template_pattern.case01;

/**
 * @description:
 * @author: lizhenzhen
 * @date: 2021-04-21 16:17
 **/
public class Application {
    public static void main(String[] args) {
        SimpleExecutor executor = new SimpleExecutor();

        int update = executor.update("{\n" +
                "    \"id\":\"001\",\n" +
                "    \"name\":\"对面公司前台\",\n" +
                "    \"sex\":\"girl\",\n" +
                "    \"ifBeautiful\":true\n" +
                "}");
    }
}
