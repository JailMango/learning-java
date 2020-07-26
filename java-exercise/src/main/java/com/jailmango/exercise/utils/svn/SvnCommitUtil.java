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
import org.springframework.util.FileCopyUtils;

/**
 * SvnCommitUtil
 *
 * @author he.gang33
 * @CreateDate 2018-12-13
 * @see com.jailmango.exercise.utils.svn
 * @since R9.0<br>
 */
public class SvnCommitUtil {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SvnCommitUtil.class);

    /**
     * 是否是V9版本
     */
    private static boolean isR9 = true;

    /**
     * 开发库对应的本地路径 - V8
     */
    private static final String DEV_PATH_V8 = "/Users/mango/Documents/repository/svn-repository/pcrf-v81/all/root/";

    /**
     * 过程库对应的本地路径 - V8
     */
    private static final String PROC_PATH_V8 = "/Users/mango/Documents/repository/commit/2119695/branches/main_branch/";

    /**
     * 前缀 - V8
     */
    private static final String PREFIX_V8 = "branches/main_branch/";

    /**
     * 开发库对应的本地路径 - R9
     */
    private static final String DEV_PATH_R9 = "/Users/mango/Documents/repository/svn-repository/PCRF-R90/";

    /**
     * 过程库对应的本地路径 - R9
     */
    private static final String PROC_PATH_R9 = "/Users/mango/Documents/repository/commit/2095820/branches/Capability_Layer/PCRF/02Product/";

    /**
     * 前缀 - R9
     */
    private static final String PREFIX_R9 = "branches/Capability_Layer/PCRF/02Product/";

    /**
     * ZMP文件变动列表文件绝对路径
     */
    private static final String SVN_FILE_LIST_FILE_PATH = "/Users/mango/Documents/repository/commit/svn-list.log";

    /**
     * 处理后文件变动列表文件绝对路径
     */
    private static final String ORDERED_SVN_FILE_LIST_FILE_PATH = "/Users/mango/Documents/repository/commit/svn-list-final.log";

    /**
     * Delete
     */
    private static final String SYMBOL_DEL = "D   ";

    /**
     * Update
     */
    private static final String SYMBOL_UPDATE = "U   ";

    /**
     * Delete
     */
    private static final String SYMBOL_ADD = "A   ";

    /**
     * Slash
     */
    private static final String SYMBOL_SLASH = "/";

    /**
     * Blank
     */
    private static final String BLANK = "";

    /**
     * 开发库对应的本地路径
     */
    private static String devPath;

    /**
     * 过程库对应的本地路径
     */
    private static String procPath;

    /**
     * 前缀
     */
    private static String prefix;

    static {
        if (isR9) {
            devPath = DEV_PATH_R9;
            procPath = PROC_PATH_R9;
            prefix = PREFIX_R9;
        }
        else {
            devPath = DEV_PATH_V8;
            procPath = PROC_PATH_V8;
            prefix = PREFIX_V8;
        }
    }

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        try {
            // 获取文件列表并排序
            List<String> list = getOrderedFilePathList(SVN_FILE_LIST_FILE_PATH);
            // 整理提交列表
            dealFilePathList(list);
            // 提交文件
            commitFile(list);
        }
        catch (IOException e) {
            logger.error(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    /**
     * 整理文件列表，删掉目录和待删除的文件
     * 
     * @param list List<String>
     * @throws IOException IOException
     */
    private static void dealFilePathList(List<String> list) throws IOException {
        if (!CollectionUtils.isEmpty(list)) {
            int delCount = 0;
            int slashCount = 0;
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
            logger.info("D -> {}, / -> {}, Commit -> {}", delCount, slashCount, list.size());
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

    /**
     * 提交文件
     * 
     * @param list List<String>
     * @throws IOException IOException
     */
    private static void commitFile(List<String> list) throws IOException {
        if (!CollectionUtils.isEmpty(list)) {
            String path;
            String devPath;
            String procPath;

            for (int index = 0; index < list.size(); index++) {
                path = list.get(index).replace(SYMBOL_UPDATE, BLANK).replace(SYMBOL_ADD, BLANK).replace(prefix, BLANK);
                devPath = SvnCommitUtil.devPath + path;
                procPath = SvnCommitUtil.procPath + path;

                FileCopyUtils.copy(new File(devPath), new File(procPath));
                logger.info("copy [{}] to [{}]", devPath, procPath);
            }
        }
    }
}
