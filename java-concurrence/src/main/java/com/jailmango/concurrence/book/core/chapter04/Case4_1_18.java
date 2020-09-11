import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 4.1.18. public boolean isHeldByCurrentThread()方法的使用 <br/>
 * 作用是查询当前线程是否保持此锁 <br/>
 *
 * @author he.gang33
 * @CreateDate 2020/8/3
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_18 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_18.class);

    public static void main(String[] args) {
        MyService service = new MyService();

        Runnable runnable = service::doService;
        new Thread(runnable).start();
    }

    private static class MyService {

        /**
         * lock
         */
        private ReentrantLock lock = new ReentrantLock();

        /**
         * doService
         */
        public void doService() {
            logger.info("[{}] isHeldByCurrentThread: [{}]", Thread.currentThread().getName(),
                lock.isHeldByCurrentThread());
            lock.lock();
            try {
                logger.info("[{}] isHeldByCurrentThread: [{}]", Thread.currentThread().getName(),
                    lock.isHeldByCurrentThread());
            }
            finally {
                lock.unlock();
            }
        }
    }
}