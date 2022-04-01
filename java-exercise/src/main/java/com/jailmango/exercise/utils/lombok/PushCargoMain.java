package com.jailmango.exercise.utils.lombok;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * PushCargoMain
 *
 * @author jailmango
 * @CreateDate 2021/10/18
 * @see com.jailmango.exercise.utils.lombok
 */
@Slf4j
public class PushCargoMain {

    /**
     * main
     *
     * @param args
     *            String[]
     */
    public static void main(String[] args) {
        Map<String, Object> content = Maps.newHashMap();
        content.put("text", "hello..");
        content.put("soundUrl", "https://www.baidu.com");

        Map<String, Object> scoreConditions = Maps.newHashMap();
        scoreConditions.put("cargoLines", Lists.newArrayList("440000_320000", "440000_320100"));
        scoreConditions.put("exposureTimes", 0);

        PushCargo cargo = PushCargo.builder().cargoId(1L).cargoScore(0.4).appType("haha").entryTime(1634525351000L).createTime(1634525351000L).scene("nPush")
            .content(content).scoreConditions(scoreConditions).build();

        String value = JSONObject.toJSONString(cargo);

        log.info(value);
    }



}
