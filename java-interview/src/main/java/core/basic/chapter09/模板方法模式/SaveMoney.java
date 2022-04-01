package core.basic.chapter09.模板方法模式;

import lombok.extern.slf4j.Slf4j;

/**
 * SaveMoney
 *
 * @author jailmango
 * @CreateDate 2020/12/15
 * @see core.basic.chapter09.模板方法模式
 * @since R9.0
 */
@Slf4j
public class SaveMoney extends AbstractTemplate {

    @Override
    public void handleBussiness() {
        log.info("save money...");
    }
}
