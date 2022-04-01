package core.basic.chapter03;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * C3_8_2_4_DelayQueue
 *
 * @author jailmango
 * @CreateDate 2020/11/18
 * @see core.basic.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_8_2_4_DelayQueue {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        DelayQueue<DelayedData> delayQueue = new DelayQueue<>();
        delayQueue.add(new DelayedData(10));
        delayQueue.add(new DelayedData(20));
        delayQueue.add(new DelayedData(30));

        while (true) {
            try {
                log.info("Getting Data...");
                DelayedData data = delayQueue.take();
                log.info("Data = {}", data.getValue());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class DelayedData implements Delayed {

        private Integer value;

        public DelayedData(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return 3000;
        }

        @Override
        public int compareTo(Delayed o) {
            DelayedData p = (DelayedData) o;
            return this.value.compareTo(p.getValue());
        }
    }
}
