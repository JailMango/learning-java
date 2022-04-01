package core.basic.chapter09.建造者模式;

import lombok.extern.slf4j.Slf4j;

/**
 * ComputerConcreteBuilder
 *
 * @author jailmango
 * @CreateDate 2020/12/10
 * @see core.basic.chapter09.建造者模式
 * @since R9.0
 */
@Slf4j
public class ComputerConcreteBuilder implements ComputerBuilder {

    private Computer computer;

    public ComputerConcreteBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCpu() {
        log.info("build cpu...");
        this.computer.setCpu("8-core");
    }

    @Override
    public void buildMemory() {
        log.info("build memory...");
        this.computer.setMemory("16G");
    }

    @Override
    public void buildDisk() {
        log.info("build disk...");
        this.computer.setDisk("256G");
    }

    @Override
    public Computer buildComputer() {
        return this.computer;
    }
}
