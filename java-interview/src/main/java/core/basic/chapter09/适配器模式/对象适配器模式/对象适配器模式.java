package core.basic.chapter09.适配器模式.对象适配器模式;

/**
 * 对象适配器模式
 *
 * @author he.gang33
 * @CreateDate 2020/12/11
 * @see core.basic.chapter09.适配器模式.对象适配器模式
 * @since R9.0
 */
public class 对象适配器模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Source source = new Source();
        Targetable target = new ObjectAdapter(source);
        target.editTxtFile();
        target.editWordFile();
    }
}
