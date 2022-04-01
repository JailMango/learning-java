package core.basic.chapter09.迭代器模式;

/**
 * Collection
 *
 * @author jailmango
 * @CreateDate 2020/12/17
 * @see core.basic.chapter09.迭代器模式
 * @since R9.0
 */
public interface Collection {

    public Iterator iterator();

    public Object get(int i);

    public boolean add(Object object);

    public int size();
}
