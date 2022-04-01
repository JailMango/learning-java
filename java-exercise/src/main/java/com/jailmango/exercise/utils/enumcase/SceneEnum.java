package com.jailmango.exercise.utils.enumcase;

import org.apache.commons.lang3.StringUtils;

/**
 * SceneEnum
 *
 * @author he.gang33
 * @CreateDate 2021/12/8
 * @see com.jailmango.exercise.utils.enumcase
 */
public enum SceneEnum {

    SCENE1(1, "scene-1"),

    SCENE2(2, "scene-2"),

    SCENE3(3, "scene-3");

    private int id;

    private String code;

    SceneEnum(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public static SceneEnum getScene(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }

        for (SceneEnum scene: SceneEnum.values()) {
            if (scene.getCode().equals(code)) {
                return scene;
            }
        }

        return null;
    }
}
