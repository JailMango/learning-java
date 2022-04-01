package core.basic.chapter09.状态模式;

/**
 * 状态模式
 *
 * @author jailmango
 * @CreateDate 2020/12/18
 * @see core.basic.chapter09.状态模式
 * @since R9.0
 */
public class 状态模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Context context = new Context(new WorkState());
        context.action();

        context.setState(new HolidayState());
        context.action();
    }
}
