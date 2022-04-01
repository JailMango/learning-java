package core.basic.chapter09.迭代器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * ListCollection
 *
 * @author jailmango
 * @CreateDate 2020/12/17
 * @see core.basic.chapter09.迭代器模式
 * @since R9.0
 */
public class ListCollection implements Collection {

    private List<Object> list = new ArrayList<>();

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this);
    }

    @Override
    public Object get(int i) {
        return list.get(i);
    }

    @Override
    public boolean add(Object object) {
        list.add(object);
        return true;
    }

    @Override
    public int size() {
        return list.size();
    }
}
