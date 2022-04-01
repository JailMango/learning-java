package core.basic.chapter09.适配器模式.对象适配器模式;

import lombok.extern.slf4j.Slf4j;

/**
 * ObjectAdapter
 *
 * @author jailmango
 * @CreateDate 2020/12/11
 * @see core.basic.chapter09.适配器模式.对象适配器模式
 * @since R9.0
 */
@Slf4j
public class ObjectAdapter implements Targetable {

    private Source source;

    public ObjectAdapter(Source source) {
        this.source = source;
    }

    @Override
    public void editTxtFile() {
        this.source.editTxtFile();
    }

    @Override
    public void editWordFile() {
        log.info("a word file editing...");
    }
}
