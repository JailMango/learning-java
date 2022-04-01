package com.jailmango.exercise.utils.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main
 *
 * @author jailmango
 * @CreateDate 2019-07-03
 * @see com.jailmango.exercise.utils.main
 * @since R9.0
 */
public class Main {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        int m = 0;
        for (int i = 0; i < args.length; i++) {
            m = i;
            // 数据配置方式
            if (args[i].compareToIgnoreCase("-db") == 0) {
                // 含数据库配置信息
                if (i + 1 < args.length) {
                    String info = args[++m];
                    if (info.charAt(0) == '-') {
                        logger.error("The database config is error!");
                        return;
                    }
                    else {
                        boolean dbLogFlag = false;
                        for (int j = 0; j < args.length; j++) {
                            if (args[j].compareToIgnoreCase("-dblog") == 0) {
                                dbLogFlag = true;
                                break;
                            }
                        }

                        logger.info("info[{}], dbLogFlag[{}]", info, dbLogFlag);
                    }
                }
                else {
                    logger.error("The database config is error!");
                    return;
                }
                // 文件配置
            }
            else if (args[i].trim().compareToIgnoreCase("-file") == 0) {
                if (i + 1 < args.length) {
                    String FileName = args[++m];
                    if (FileName.charAt(0) == '-') {
                        logger.warn("The file config is empty!");
                    }
                    else {
                        logger.info("filename[{}]", FileName);
                    }
                }
                else {
                    logger.warn("The file config is empty!");
                }
                // cvBS配置
            }
            else if (args[i].trim().compareToIgnoreCase("-cvbs") == 0) {
                // 含数据库配置信息
                if (i + 1 < args.length) {
                    String info = args[++m];
                    if (info.charAt(0) == '-') {
                        logger.error("The database config is error!");
                        return;
                    }
                    else {
                        boolean dbLogFlag = false;
                        for (int j = 0; j < args.length; j++) {
                            if (args[j].compareToIgnoreCase("-dblog") == 0) {
                                dbLogFlag = true;
                                break;
                            }
                        }
                        logger.info("info[{}], dbLogFlag[{}]", info, dbLogFlag);
                    }
                }
                else {
                    logger.error("The database config is error!");
                    return;
                }
                // 版本号
            }
            else if (args[i].trim().compareToIgnoreCase("-v") == 0) {
                logger.info("version");
                // 启动程序
            }
            else if (args[i].trim().compareToIgnoreCase("-start") == 0) {
                logger.info("run");
                // 停止程序
            }
            else if (args[i].trim().compareToIgnoreCase("-stop") == 0) {
                logger.info("stop");

            }
        }
        logger.info("end...");
    }
}
