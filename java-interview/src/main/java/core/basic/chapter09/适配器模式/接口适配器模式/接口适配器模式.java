package core.basic.chapter09.适配器模式.接口适配器模式;

/**
 * 接口适配器模式
 *
 * @author jailmango
 * @CreateDate 2020/12/13
 * @see core.basic.chapter09.适配器模式.接口适配器模式
 * @since R9.0
 */
public class 接口适配器模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Sourceable source1 = new SourceSub1();
        Sourceable source2 = new SourceSub2();

        source1.editTextFile();
        source1.editWordFile();

        source2.editTextFile();
        source2.editWordFile();
    }
}
