package core.basic.chapter09.建造者模式;

import lombok.extern.slf4j.Slf4j;

/**
 * 建造者模式
 *
 * @author jailmango
 * @CreateDate 2020/12/10
 * @see core.basic.chapter09.建造者模式
 * @since R9.0
 */
@Slf4j
public class 建造者模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();
        ComputerBuilder builder = new ComputerConcreteBuilder();
        Computer computer = director.constructComputer(builder);

        log.info("CPU = {}, Memory = {}, Disk = {}", computer.getCpu(), computer.getMemory(), computer.getDisk());
    }
}
