package core.basic.chapter09.建造者模式;

/**
 * ComputerBuilder
 *
 * @author he.gang33
 * @CreateDate 2020/12/10
 * @see core.basic.chapter09.建造者模式
 * @since R9.0
 */
public interface ComputerBuilder {

    void buildCpu();

    void buildMemory();

    void buildDisk();

    Computer buildComputer();
}
