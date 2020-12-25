package core.basic.chapter09.备忘录模式;

/**
 * Storage
 *
 * @author he.gang33
 * @CreateDate 2020/12/17
 * @see core.basic.chapter09.备忘录模式
 * @since R9.0
 */
public class Storage {

    private Memento memento;

    public Storage(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
