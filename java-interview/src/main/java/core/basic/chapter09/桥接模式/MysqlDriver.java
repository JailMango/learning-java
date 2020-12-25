package core.basic.chapter09.桥接模式;

import lombok.extern.slf4j.Slf4j;

/**
 * MysqlDriver
 *
 * @author he.gang33
 * @CreateDate 2020/12/14
 * @see core.basic.chapter09.桥接模式
 * @since R9.0
 */
@Slf4j
public class MysqlDriver implements Driver {

    @Override
    public void executeSQL() {
        log.info("execute SQL by mysql driver...");
    }
}
