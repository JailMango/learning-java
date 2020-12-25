package core.basic.chapter09.访问者模式;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;

/**
 * CTOVisitor
 *
 * @author he.gang33
 * @CreateDate 2020/12/18
 * @see core.basic.chapter09.访问者模式
 * @since R9.0
 */
@Slf4j
public class CTOVisitor implements Visitor {

    @Override
    public void visit(ProjectElement element) {
        log.info("CTO Visitor Element...");
        element.signature("CTO", new Date());
        log.info("{}", element.toString());
    }
}
