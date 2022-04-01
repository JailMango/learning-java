package core.basic.chapter09.享元模式;

/**
 * 享元模式
 *
 * @author jailmango
 * @CreateDate 2020/12/15
 * @see core.basic.chapter09.享元模式
 * @since R9.0
 */
public class 享元模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Memory memory = MemoryFactory.getMemory(32);
        MemoryFactory.releaseMemory(memory.getId());
        MemoryFactory.getMemory(32);
    }
}
