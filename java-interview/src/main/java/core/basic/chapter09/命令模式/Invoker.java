package core.basic.chapter09.命令模式;

import lombok.extern.slf4j.Slf4j;

/**
 * Invoker
 *
 * @author he.gang33
 * @CreateDate 2020/12/17
 * @see core.basic.chapter09.命令模式
 * @since R9.0
 */
@Slf4j
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(String message) {
        log.info("send command...");
        command.exe(message);
    }
}
