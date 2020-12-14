package core.basic.chapter09.装饰者模式;

import lombok.extern.slf4j.Slf4j;

/**
 * Decorator
 *
 * @author he.gang33
 * @CreateDate 2020/12/14
 * @see core.basic.chapter09.装饰者模式
 * @since R9.0
 */
@Slf4j
public class Decorator implements Sourceable {

    private Sourceable source;

    public Decorator(Sourceable source) {
        super();
        this.source = source;
    }

    @Override
    public void createComputer() {
        source.createComputer();
        log.info("make system...");
    }
}
