package core.basic.chapter09.原型模式;

/**
 * Computer
 *
 * @author he.gang33
 * @CreateDate 2020/12/10
 * @see core.basic.chapter09.原型模式
 * @since R9.0
 */
public class Computer implements Cloneable {

    private String cpu;

    private String memory;

    private String disk;

    public Computer(String cpu, String memory, String disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    @Override
    protected Computer clone() {
        try {
            return (Computer) super.clone();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

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
