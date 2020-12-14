package core.basic.chapter03;

import lombok.extern.slf4j.Slf4j;

/**
 * C3_10_1_将数据抽象成一个类_将操作封装在类的方法中
 *
 * @author he.gang33
 * @CreateDate 2020/11/19
 * @see core.basic.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_10_1_将数据抽象成一个类_将操作封装在类的方法中 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Data data = new Data();
        Runnable add = new AddRunnable(data);
        Runnable dec = new DecRunnable(data);

        for (int i = 0; i < 5; i++) {
            new Thread(add).start();
            new Thread(dec).start();
        }
    }

    private static class AddRunnable implements Runnable {

        private Data data;

        public AddRunnable(Data data) {
            this.data = data;
        }

        @Override
        public void run() {
            data.add();
        }
    }

    private static class DecRunnable implements Runnable {

        private Data data;

        public DecRunnable(Data data) {
            this.data = data;
        }

        @Override
        public void run() {
            data.dec();
        }
    }

    private static class Data {

        private int j = 0;

        public synchronized void add() {
            j++;
            log.info("j = {}", j);
        }

        public synchronized void dec() {
            j--;
            log.info("j = {}", j);
        }

        public int getData() {
            return j;
        }
    }

}
