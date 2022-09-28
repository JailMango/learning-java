package com.jailmango.exercise.utils.json;

import lombok.extern.slf4j.Slf4j;

/**
 * GsonCase
 *
 * @author hegang1
 * @CreateDate 2022/8/10
 * @see com.jailmango.exercise.utils.json
 */
@Slf4j
public class GsonCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        GetApiGateway ins = new GetApiGateway();
        ins.sendRequest();
    }
}
