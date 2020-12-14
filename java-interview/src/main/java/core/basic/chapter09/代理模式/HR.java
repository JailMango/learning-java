package core.basic.chapter09.代理模式;

import lombok.extern.slf4j.Slf4j;

/**
 * HR
 *
 * @author he.gang33
 * @CreateDate 2020/12/14
 * @see core.basic.chapter09.代理模式
 * @since R9.0
 */
@Slf4j
public class HR implements Company {

    @Override
    public void findWorker(String title) {
        log.info("i need find a worker, title is {}", title);
    }
}
