package core.basic.chapter09.备忘录模式;

/**
 * Memento
 *
 * @author jailmango
 * @CreateDate 2020/12/17
 * @see core.basic.chapter09.备忘录模式
 * @since R9.0
 */
public class Memento {

    private String value;

    public Memento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
