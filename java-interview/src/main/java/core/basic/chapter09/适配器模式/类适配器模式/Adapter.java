package core.basic.chapter09.适配器模式.类适配器模式;

import lombok.extern.slf4j.Slf4j;

/**
 * Adapter
 *
 * @author he.gang33
 * @CreateDate 2020/12/10
 * @see core.basic.chapter09.适配器模式
 * @since R9.0
 */
@Slf4j
public class Adapter extends Source implements Targetable {

    @Override
    public void editWordFile() {
        log.info("a word file editing...");
    }
}
