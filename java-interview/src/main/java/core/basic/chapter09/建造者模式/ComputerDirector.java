package core.basic.chapter09.建造者模式;

/**
 * ComputerDirector
 *
 * @author jailmango
 * @CreateDate 2020/12/10
 * @see core.basic.chapter09.建造者模式
 * @since R9.0
 */
public class ComputerDirector {

    public Computer constructComputer(ComputerBuilder builder) {
        builder.buildMemory();
        builder.buildCpu();
        builder.buildDisk();
        return builder.buildComputer();
    }
}
