package core.basic.chapter09.访问者模式;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;

/**
 * CEOVisitor
 *
 * @author he.gang33
 * @CreateDate 2020/12/18
 * @see core.basic.chapter09.访问者模式
 * @since R9.0
 */
@Slf4j
public class CEOVisitor implements Visitor {

    @Override
    public void visit(ProjectElement element) {
        log.info("CEO Visitor Element...");
        element.signature("CEO", new Date());
        log.info("{}", element.toString());
    }
}
