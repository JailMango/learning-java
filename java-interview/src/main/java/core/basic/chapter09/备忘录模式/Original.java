package core.basic.chapter09.备忘录模式;

/**
 * Original
 *
 * @author he.gang33
 * @CreateDate 2020/12/17
 * @see core.basic.chapter09.备忘录模式
 * @since R9.0
 */
public class Original {

    private String value;

    public Original(String value) {
        this.value = value;
    }

    public Memento createMemento() {
        return new Memento(value);
    }

    public void restoreMemento(Memento memento) {
        this.value = memento.getValue();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
