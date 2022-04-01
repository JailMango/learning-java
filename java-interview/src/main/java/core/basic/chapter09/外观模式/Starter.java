package core.basic.chapter09.外观模式;

import lombok.extern.slf4j.Slf4j;

/**
 * Starter
 *
 * @author jailmango
 * @CreateDate 2020/12/14
 * @see core.basic.chapter09.外观模式
 * @since R9.0
 */
@Slf4j
public class Starter {

    private DashBoard dashBoard;

    private Engine engine;

    private SelfCheck selfCheck;

    public Starter() {
        this.dashBoard = new DashBoard();
        this.engine = new Engine();
        this.selfCheck = new SelfCheck();
    }

    public void startup() {
        log.info("car begin startup...");
        engine.startup();
        dashBoard.startup();
        selfCheck.startupCheck();
        log.info("car begin finished...");
    }

    public void shutdown() {
        log.info("car begin shutdown...");
        selfCheck.shutdownCheck();
        engine.shutdown();
        dashBoard.shutdown();
        log.info("car shutdown finished...");
    }

}
