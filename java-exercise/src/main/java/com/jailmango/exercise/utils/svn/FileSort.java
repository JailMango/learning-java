package com.jailmango.exercise.utils.svn;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

/**
 * FileSort
 *
 * @author jailmango
 * @CreateDate 2018-12-13
 * @see com.jailmango.exercise.utils.svn
 * @since R9.0<br>
 */
public class FileSort {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(FileSort.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        try {
            String filePath = "/Users/mango/Documents/repository/commit/svn-list-ordered.log";
            List<String> list = getOrderedFilePathList(filePath);

            if (!CollectionUtils.isEmpty(list)) {
                String orderedFilePath = "/Users/mango/Documents/repository/commit/ordered.log";
                FileUtils.writeLines(new File(orderedFilePath), list);
            }

            String filePath1 = "/Users/mango/Downloads/svn.log";
            List<String> list1 = getOrderedFilePathList(filePath1);

            if (!CollectionUtils.isEmpty(list1)) {
                String orderedFilePath1 = "/Users/mango/Documents/repository/commit/ordered-1.log";
                FileUtils.writeLines(new File(orderedFilePath1), list1);
            }

        }
        catch (IOException e) {
            logger.error(e.getLocalizedMessage());
        }
    }

    /**
     * 获取文件列表并排序
     * 
     * @param srcFilePath String
     * @return List<String>
     * @throws IOException IOException
     */
    private static List<String> getOrderedFilePathList(String srcFilePath) throws IOException {
        List<String> list = FileUtils.readLines(new File(srcFilePath), StandardCharsets.UTF_8);
        Collections.sort(list);
        return list;
    }
}
