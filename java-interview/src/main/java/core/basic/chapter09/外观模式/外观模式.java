package core.basic.chapter09.外观模式;

import lombok.extern.slf4j.Slf4j;

/**
 * 外观模式
 *
 * @author jailmango
 * @CreateDate 2020/12/14
 * @see core.basic.chapter09.外观模式
 * @since R9.0
 */
@Slf4j
public class 外观模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Starter starter = new Starter();
        starter.startup();
        log.info("==================");
        starter.shutdown();
    }
}
