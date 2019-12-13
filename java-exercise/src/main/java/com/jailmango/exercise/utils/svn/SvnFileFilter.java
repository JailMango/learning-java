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
 * SvnFileUtil
 *
 * @author he.gang33
 * @CreateDate 2018-12-13
 * @see com.jailmango.exercise.utils.svn
 * @since R9.0<br>
 */
public class SvnFileFilter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SvnFileFilter.class);

    /**
     * ZMP文件变动列表文件绝对路径
     */
    private static final String SVN_FILE_LIST_FILE_PATH = "/Users/mango/Documents/repository/commit/svn-list.log";

    /**
     * 处理后文件变动列表文件绝对路径
     */
    private static final String ORDERED_SVN_FILE_LIST_FILE_PATH = "/Users/mango/Documents/repository/commit/svn-list-ordered.log";

    /**
     * Delete
     */
    private static final String SYMBOL_DEL = "D   ";

    /**
     * Slash
     */
    private static final String SYMBOL_SLASH = "/";

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        try {
            int delCount = 0;
            int slashCount = 0;

            List<String> list = getOrderedFilePathList(SVN_FILE_LIST_FILE_PATH);

            if (!CollectionUtils.isEmpty(list)) {
                Iterator<String> iterator = list.iterator();

                while (iterator.hasNext()) {
                    String path = iterator.next().trim();

                    if (StringUtils.startsWith(path, SYMBOL_DEL)) {
                        delCount++;
                        iterator.remove();
                    }
                    else if (StringUtils.endsWith(path, SYMBOL_SLASH)) {
                        slashCount++;
                        iterator.remove();
                    }

                }

                FileUtils.writeLines(new File(ORDERED_SVN_FILE_LIST_FILE_PATH), list);
            }

            logger.info("Del -> {}, Slash -> {}", delCount, slashCount);
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
