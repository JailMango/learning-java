package core.basic.chapter09.迭代器模式;

/**
 * Iterator
 *
 * @author he.gang33
 * @CreateDate 2020/12/17
 * @see core.basic.chapter09.迭代器模式
 * @since R9.0
 */
public interface Iterator {

    public Object previous();

    public Object next();

    public boolean hasNext();
}
