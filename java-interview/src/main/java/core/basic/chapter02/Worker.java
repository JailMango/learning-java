package core.basic.chapter02;

/**
 * Worker
 *
 * @author jailmango
 * @CreateDate 2020/11/17
 * @see core.basic.chapter02
 * @since R9.0
 */
public abstract class Worker {

    private String name;

    public abstract int workTime();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
