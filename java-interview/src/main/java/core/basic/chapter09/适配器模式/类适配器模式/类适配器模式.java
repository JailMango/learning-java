package core.basic.chapter09.适配器模式.类适配器模式;

/**
 * 类适配器模式
 *
 * @author jailmango
 * @CreateDate 2020/12/10
 * @see core.basic.chapter09.适配器模式
 * @since R9.0
 */
public class 类适配器模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.editTxtFile();
        target.editWordFile();
    }
}
