package core.basic.chapter09.原型模式;

import lombok.extern.slf4j.Slf4j;

/**
 * 原型模式
 *
 * @author jailmango
 * @CreateDate 2020/12/10
 * @see core.basic.chapter09.原型模式
 * @since R9.0
 */
@Slf4j
public class 原型模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Computer computer = new Computer("8core", "16G", "1TB");
        log.info("before simple clone: CPU = {}, Memory = {}, Disk = {}", computer.getCpu(), computer.getMemory(),
            computer.getDisk());
        Computer computerClone = computer.clone();
        log.info("after simple clone: CPU = {}, Memory = {}, Disk = {}", computerClone.getCpu(),
            computerClone.getMemory(), computerClone.getDisk());

        Disk disk = new Disk("256GB", "2TB");
        ComputerDetail computerDetail = new ComputerDetail("12core", "64GB", disk);
        log.info("before simple clone: CPU = {}, Memory = {}, Disk = {}", computerDetail.getCpu(),
            computerDetail.getMemory(), computerDetail.getDisk());
        ComputerDetail computerDetailClone = (ComputerDetail) computerDetail.clone();
        log.info("after simple clone: CPU = {}, Memory = {}, Disk = {}", computerDetailClone.getCpu(),
            computerDetailClone.getMemory(), computerDetailClone.getDisk());
    }
}
