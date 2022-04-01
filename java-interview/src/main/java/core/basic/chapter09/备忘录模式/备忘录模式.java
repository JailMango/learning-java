package core.basic.chapter09.备忘录模式;

import lombok.extern.slf4j.Slf4j;

/**
 * 备忘录模式
 *
 * @author jailmango
 * @CreateDate 2020/12/18
 * @see core.basic.chapter09.备忘录模式
 * @since R9.0
 */
@Slf4j
public class 备忘录模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Original original = new Original("张三");
        Storage storage = new Storage(original.createMemento());

        log.info("origin value: {}", original.getValue());

        original.setValue("李四");
        log.info("update value: {}", original.getValue());

        original.restoreMemento(storage.getMemento());
        log.info("restore value: {}", original.getValue());
    }
}
