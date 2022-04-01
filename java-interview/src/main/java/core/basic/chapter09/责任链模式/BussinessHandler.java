package core.basic.chapter09.责任链模式;

import lombok.extern.slf4j.Slf4j;

/**
 * BussinessHandler
 *
 * @author jailmango
 * @CreateDate 2020/12/17
 * @see core.basic.chapter09.责任链模式
 * @since R9.0
 */
@Slf4j
public class BussinessHandler extends AbstractHandler implements Handler {

    private String name;

    public BussinessHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        log.info("do bussiness...");

        if (getHandler() != null) {
            getHandler().operator();
        }
    }
}
