package com.jailmango.exercise.utils.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SecurityCase
 *
 * @author he.gang33
 * @CreateDate 2019-01-10
 * @see com.jailmango.exercise.utils.security
 * @since R9.0<br>
 */
public class SecurityCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SecurityCase.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        try {
            String ePwd = SecurityUtils.encrypt("zhouwei123");
            logger.info(ePwd);
            String dPwd = SecurityUtils.decrypt("gezvqd3CWyI=");
            logger.info(dPwd);

            CoreKeyProperties coreKeyProperties = new CoreKeyProperties();
            String privKeyPath = coreKeyProperties.getRsaPrivPath();
            String privPwd = coreKeyProperties.getRsaPwd();

            logger.info("privKeyPath:[{}]", privKeyPath);
            logger.info("privPwd:[{}]", privPwd);
        }
        catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }
    }
}
