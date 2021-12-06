package com.jailmango.exercise.utils.json;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

/**
 * JsonCase
 *
 * @author he.gang33
 * @CreateDate 2021/10/26
 * @see com.jailmango.exercise.utils.json
 */
@Slf4j
public class JsonCase {

    /**
     * main
     *
     * @param args
     *            String[]
     */
    public static void main(String[] args) {

        long now = System.currentTimeMillis();


        long now1 = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        // 校验
        boolean success = Optional.ofNullable(null).isPresent();

        PushCargo cargo = PushCargo.builder().cargoId(10141405282986L).userId(965006065497144327L)
                .scene(PushSceneEnum.REPUSH).accessTime(now()).rankScore(0.111111111111111111111).build();

        String jsonString = JSONObject.toJSONString(cargo);
        log.info("{}", jsonString);

        PushCargo cargo1 = JSONObject.parseObject(jsonString, PushCargo.class);



        log.info("end...");
    }

    private static long now() {
        return LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    private static class PushCargo {

        /**
         * 货源ID
         */
        @JSONField(name = "cid")
        protected Long cargoId;

        /**
         * push场景
         */
        protected PushSceneEnum scene;

        /**
         * 入队时间
         */
        protected Long accessTime;

        /**
         * 货源上架时间
         */
        protected Long createTime;

        /**
         * 扩展字段
         */
        @JSONField(serialize = false, deserialize = false)
        protected String extras;

        /**
         * 用户ID
         */
        @JSONField(name = "uid")
        private Long userId;

        /**
         * 货源质量分
         */
        @JSONField(name = "score")
        private Double rankScore;
    }

    private enum PushSceneEnum {
        /**
         * N次推
         */
        REPUSH(1, "repush", "N次推", "repeat_push_cargo_id");

        PushSceneEnum(Integer id, String code, String desc, String precScene) {
            this.id = id;
            this.code = code;
            this.desc = desc;
            this.precScene = precScene;
        }

        /**
         * 场景id
         */
        private Integer id;

        /**
         * 场景code
         */
        private String code;

        /**
         * 场景描述
         */
        private String desc;

        /**
         * 埋点场景
         */
        private String precScene;

        public Integer getId() {
            return id;
        }

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

        public String getPrecScene() {
            return precScene;
        }

        @Override
        public String toString() {
            return String.valueOf(id);
        }
    }
}
