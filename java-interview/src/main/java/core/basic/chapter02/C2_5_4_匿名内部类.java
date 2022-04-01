package core.basic.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * C2_5_4_匿名内部类
 *
 * @author jailmango
 * @CreateDate 2020/11/17
 * @see core.basic.chapter02
 * @since R9.0
 */
@Slf4j
public class C2_5_4_匿名内部类 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        C2_5_4_匿名内部类 ins = new C2_5_4_匿名内部类();
        ins.doWork(new Worker() {
            @Override
            public int workTime() {
                return 0;
            }

            @Override
            public String getName() {
                return "Anonymous Class";
            }
        });
    }

    public void doWork(Worker worker) {
        log.info("{} Work Time = {}", worker.getName(), worker.workTime());
    }
}
