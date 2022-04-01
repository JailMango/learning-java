package com.jailmango.exercise.utils.enumcase;

import lombok.extern.slf4j.Slf4j;

/**
 * EnumCase
 *
 * @author jailmango
 * @CreateDate 2021/12/8
 * @see com.jailmango.exercise.utils.enumcase
 */
@Slf4j
public class EnumCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        SceneEnum scene1 = SceneEnum.getScene("scene-1");

        SceneEnum scene2 = SceneEnum.getScene("scene-2");

        SceneEnum scene3 = SceneEnum.getScene("scene");

        log.info("end...");
    }
}
