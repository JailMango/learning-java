package com.jailmango.exercise.utils.jdk;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * EnumCase
 *
 * @author he.gang33
 * @CreateDate 2020/9/23
 * @see com.jailmango.exercise.utils.jdk
 * @since R9.0
 */
public class EnumCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(EnumCase.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        BaseResp resp = new BaseResp();

        if (resp.result.equals(ResultEnum.FAIL)) {
            logger.info("result is fail...");
        }
        else {
            logger.info("result is success...");
        }

        resp.setResult(ResultEnum.SUCCESS);

        if (resp.result == ResultEnum.SUCCESS) {
            logger.info("result is success...");
        }
        else {
            logger.info("result is fail...");
        }
    }

    private static class BaseResp implements Serializable {

        private static final long serialVersionUID = 401130070679892879L;

        ResultEnum result = ResultEnum.FAIL;

        public ResultEnum getResult() {
            return result;
        }

        public void setResult(ResultEnum result) {
            this.result = result;
        }
    }
}
