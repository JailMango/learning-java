package core.basic.chapter02;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import lombok.extern.slf4j.Slf4j;

/**
 * C2_4_3_注解处理器
 *
 * @author jailmango
 * @CreateDate 2020/11/16
 * @see core.basic.chapter02
 * @since R9.0
 */
@Slf4j
public class C2_4_3_注解处理器 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        FruitInfoUtil.getFruitInfo(Apple.class);
        log.info("end...");
    }

    /**
     * 苹果
     */
    private class Apple {

        @FruitProvider(id = 1, name = "Apple-Provider", address = "Apple-Addr")
        private String provider;

        public String getProvider() {
            return provider;
        }

        public void setProvider(String provider) {
            this.provider = provider;
        }
    }

    /**
     * 注解
     */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    private @interface FruitProvider {

        int id() default -1;

        String name() default "";

        String address() default "";
    }

    /**
     * 注解处理器
     */
    private static class FruitInfoUtil {

        public static void getFruitInfo(Class<?> clazz) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(FruitProvider.class)) {
                    FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                    log.info("供应商编码[{}], 名称[{}], 地址[{}]", fruitProvider.id(), fruitProvider.name(),
                        fruitProvider.address());
                }
            }
        }
    }
}
