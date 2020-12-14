package core.basic.chapter09.原型模式;

/**
 * Disk
 *
 * @author he.gang33
 * @CreateDate 2020/12/10
 * @see core.basic.chapter09.原型模式
 * @since R9.0
 */
public class Disk implements Cloneable {

    private String ssd;

    private String hhd;

    public Disk(String ssd, String hhd) {
        this.ssd = ssd;
        this.hhd = hhd;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            return (Disk) super.clone();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
