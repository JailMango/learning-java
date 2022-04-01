package core.basic.chapter09.迭代器模式;

import lombok.extern.slf4j.Slf4j;

/**
 * 迭代器模式
 *
 * @author jailmango
 * @CreateDate 2020/12/17
 * @see core.basic.chapter09.迭代器模式
 * @since R9.0
 */
@Slf4j
public class 迭代器模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Collection collection = new ListCollection();
        collection.add("obj1");

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            log.info("{}", iterator.next());
        }
    }
}
