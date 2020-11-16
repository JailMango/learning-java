import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import lombok.extern.slf4j.Slf4j;

/**
 * ReadWriteLock读写锁_3_1_4
 *
 * @author he.gang33
 * @CreateDate 2020/10/6
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_1_4_ReadWriteLock读写锁 {

    private static Lock lock = new ReentrantLock();

    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    private static Lock readLock = reentrantReadWriteLock.readLock();

    private static Lock writeLock = reentrantReadWriteLock.writeLock();

    private int value;

    public void handleRead(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(1000);
            log.info("read value: [{}]", this.value);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock, int index) {
        try {
            lock.lock();
            Thread.sleep(1000);
            this.value = index;
            log.info("write [{}]", index);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        C3_1_4_ReadWriteLock读写锁 ins = new C3_1_4_ReadWriteLock读写锁();
        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                ins.handleRead(readLock);
            }
        };

        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                ins.handleWrite(writeLock, new Random().nextInt());
            }
        };

        for (int i = 0; i < 20; i++) {
            new Thread(readRunnable).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(writeRunnable).start();
        }
    }
}