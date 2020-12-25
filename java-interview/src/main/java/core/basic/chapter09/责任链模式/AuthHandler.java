package core.basic.chapter09.责任链模式;

import lombok.extern.slf4j.Slf4j;

/**
 * AuthHandler
 *
 * @author he.gang33
 * @CreateDate 2020/12/17
 * @see core.basic.chapter09.责任链模式
 * @since R9.0
 */
@Slf4j
public class AuthHandler extends AbstractHandler implements Handler {

    private String name;

    public AuthHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        log.info("auth...");

        if (getHandler() != null) {
            getHandler().operator();
        }
    }
}
