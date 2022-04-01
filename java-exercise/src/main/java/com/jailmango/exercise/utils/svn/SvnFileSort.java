package com.jailmango.exercise.utils.svn;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

/**
 * SvnFileUtil
 *
 * @author jailmango
 * @CreateDate 2018-12-13
 * @see com.jailmango.exercise.utils.svn
 * @since R9.0<br>
 */
public class SvnFileSort {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SvnFileSort.class);

    /**
     * ZMP文件变动列表文件绝对路径
     */
    private static final String SVN_FILE_LIST_FILE_PATH = "/Users/mango/Documents/repository/commit/svn-list.log";

    /**
     * 处理后文件变动列表文件绝对路径
     */
    private static final String ORDERED_SVN_FILE_LIST_FILE_PATH = "/Users/mango/Documents/repository/commit/svn-list-ordered.log";

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        try {
            List<String> list = getOrderedFilePathList(SVN_FILE_LIST_FILE_PATH);

            if (!CollectionUtils.isEmpty(list)) {
                FileUtils.writeLines(new File(ORDERED_SVN_FILE_LIST_FILE_PATH), list);
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
        String path = "";

        for (int i = 0; i < list.size(); i++) {
            path = list.get(i);
            path = path.substring(4, path.length());
            list.set(i, path);
        }
        Collections.sort(list);
        return list;
    }
}
