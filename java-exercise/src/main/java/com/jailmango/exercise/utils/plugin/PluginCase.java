package com.jailmango.exercise.utils.plugin;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * PluginCase
 *
 * @author gang.he2
 * @see com.jailmango.exercise.utils.plugin
 */
public class PluginCase {

    public void patch(String jarPath) {
        try {
            ClassPool pool = ClassPool.getDefault();
            pool.insertClassPath(jarPath);
            CtClass cc = pool.get("com.ymm.opendoom.plugin.acceleratepigeon.utils.FileUtil");
//            CtClass cc = pool.get("io.manbang.zodiac.plugin.acceleratepigeon.utils.FileUtil");
            CtMethod ms = cc.getDeclaredMethod("getDoomConfigProperties");
            ms.setBody("{return readProperties(System.getProperty(\"config.path\"), \"doomConfig\");}");
            cc.writeFile("/Users/mango/Documents/ymm/data/boot/doom-jar/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PluginCase().patch("/Users/mango/Documents/ymm/data/boot/doom-jar/acceleratepigeon.jar");
    }

}
