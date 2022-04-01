package core.basic.chapter09.原型模式;

/**
 * ComputerDetail
 *
 * @author jailmango
 * @CreateDate 2020/12/10
 * @see core.basic.chapter09.原型模式
 * @since R9.0
 */
public class ComputerDetail implements Cloneable {

    private String cpu;

    private String memory;

    private Disk disk;

    public ComputerDetail(String cpu, String memory, Disk disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    @Override
    protected Object clone() {
        try {
            ComputerDetail computerDetail = (ComputerDetail) super.clone();
            computerDetail.disk = (Disk) this.disk.clone();
            return computerDetail;
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

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }
}
