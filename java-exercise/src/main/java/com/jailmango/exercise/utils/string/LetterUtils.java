package com.jailmango.exercise.utils.string;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import static com.alibaba.fastjson.parser.Feature.SupportNonPublicField;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * LetterUtils
 *
 * @author jailmango
 * @CreateDate 2021/11/2
 * @see com.jailmango.exercise.utils.string
 */
public class LetterUtils {

    private static final String GTR_SCENE = "reachAccess%sScene";

    /**
     * main
     *
     * @param args
     *            String[]
     */
    public static void main(String[] args) {

        Cat c1 = new Cat();
        c1.setName("c1");
        Cat c2 = new Cat();
        c2.setName("c2");
        Map<String, String> map = Maps.newHashMap();
        map.put("cat1", JSONObject.toJSONString(c1));
        map.put("cat2", JSONObject.toJSONString(c2));

        String str = JSONObject.toJSONString(map);

        Animal a = JSONObject.parseObject(str, Animal.class);

        Map<String, String> map1 = JSONObject.parseObject(JSONObject.toJSONString(a), Map.class);

        int d = 1;

    }
}

class Animal {

    @JSONField(deserializeUsing = Cat.class, parseFeatures = SupportNonPublicField)
    public Cat cat1;

    @JSONField(deserializeUsing = Cat.class, parseFeatures = SupportNonPublicField)
    public Cat cat2;

    public Cat getCat1() {
        return cat1;
    }

    public void setCat1(Cat cat1) {
        this.cat1 = cat1;
    }

    public Cat getCat2() {
        return cat2;
    }

    public void setCat2(Cat cat2) {
        this.cat2 = cat2;
    }
}

class Cat {

    @JSONField(parseFeatures = SupportNonPublicField)
    public String name;

    public Cat() {}

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
