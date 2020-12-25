package core.basic.chapter09.责任链模式;

import lombok.extern.slf4j.Slf4j;

/**
 * ResponseHandler
 *
 * @author he.gang33
 * @CreateDate 2020/12/17
 * @see core.basic.chapter09.责任链模式
 * @since R9.0
 */
@Slf4j
public class ResponseHandler extends AbstractHandler implements Handler {

    private String name;

    public ResponseHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        log.info("response...");

        if (getHandler() != null) {
            getHandler().operator();
        }
    }
}
