package core.basic.chapter03;

import java.util.concurrent.PriorityBlockingQueue;

import lombok.extern.slf4j.Slf4j;

/**
 * C3_8_2_3_PriorityBlockingQueue
 *
 * @author he.gang33
 * @CreateDate 2020/11/18
 * @see core.basic.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_8_2_3_PriorityBlockingQueue {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        PriorityBlockingQueue<Data> priorityBlockingQueue = new PriorityBlockingQueue<>();
    }

    private static class Data implements Comparable<Data> {

        private String id;

        private Integer value;

        @Override
        public int compareTo(Data o) {
            return this.value.compareTo(o.value);
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }
}
