package core.basic.chapter09.代理模式;

/**
 * 代理模式
 *
 * @author jailmango
 * @CreateDate 2020/12/14
 * @see core.basic.chapter09.代理模式
 * @since R9.0
 */
public class 代理模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Company company  = new Proxy();
        company.findWorker("Java");
    }
}
