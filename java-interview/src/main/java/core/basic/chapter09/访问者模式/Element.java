package core.basic.chapter09.访问者模式;

/**
 * Element
 *
 * @author he.gang33
 * @CreateDate 2020/12/18
 * @see core.basic.chapter09.访问者模式
 * @since R9.0
 */
public interface Element {

    void accept(Visitor visitor);
}
