package core.basic.chapter09.建造者模式;

/**
 * Computer
 *
 * @author he.gang33
 * @CreateDate 2020/12/10
 * @see core.basic.chapter09.建造者模式
 * @since R9.0
 */
public class Computer {

    private String cpu;

    private String memory;

    private String disk;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }
}
