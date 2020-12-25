package core.basic.chapter09.享元模式;

import lombok.ToString;

/**
 * Memory
 *
 * @author he.gang33
 * @CreateDate 2020/12/15
 * @see core.basic.chapter09.享元模式
 * @since R9.0
 */
@ToString
public class Memory {

    private int size;

    private boolean isused;

    private String id;

    public Memory(int size, boolean isused, String id) {
        this.size = size;
        this.isused = isused;
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isIsused() {
        return isused;
    }

    public void setIsused(boolean isused) {
        this.isused = isused;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
