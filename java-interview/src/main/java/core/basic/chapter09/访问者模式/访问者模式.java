package core.basic.chapter09.访问者模式;

/**
 * 访问者模式
 *
 * @author he.gang33
 * @CreateDate 2020/12/18
 * @see core.basic.chapter09.访问者模式
 * @since R9.0
 */
public class 访问者模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Element element = new ProjectElement("mobike", "share bike");
        element.accept(new CEOVisitor());
        element.accept(new CTOVisitor());
    }
}
