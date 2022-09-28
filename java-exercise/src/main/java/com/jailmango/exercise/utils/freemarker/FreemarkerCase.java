package com.jailmango.exercise.utils.freemarker;

import com.google.common.base.Splitter;

import java.util.List;

/**
 * FreemarkerCase
 *
 * @author hegang1
 * @CreateDate 2022/8/24
 * @see com.jailmango.exercise.utils.freemarker
 */
public class FreemarkerCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        String url = "smj-sit-1255000009.ccf.csp.cloud.nesc.com.cn/software/demo.html";
        String splitter = "smj-sit-1255000009.ccf.csp.cloud.nesc.com.cn";

        List<String> list = Splitter.on(splitter).splitToList(url);

        int a = 1;
    }
}
