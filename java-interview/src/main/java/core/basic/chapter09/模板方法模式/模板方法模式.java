package core.basic.chapter09.模板方法模式;

import lombok.extern.slf4j.Slf4j;

/**
 * 模板方法模式
 *
 * @author he.gang33
 * @CreateDate 2020/12/15
 * @see core.basic.chapter09.模板方法模式
 * @since R9.0
 */
@Slf4j
public class 模板方法模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        AbstractTemplate takeMoney = new TakeMoney();
        takeMoney.templateMethod();

        log.info("===================");

        AbstractTemplate saveMoney = new SaveMoney();
        saveMoney.templateMethod();
    }
}
