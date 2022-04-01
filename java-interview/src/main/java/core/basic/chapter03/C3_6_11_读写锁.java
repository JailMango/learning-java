package core.basic.chapter03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import lombok.extern.slf4j.Slf4j;

/**
 * C3_6_11_读写锁
 *
 * @author jailmango
 * @CreateDate 2020/11/18
 * @see core.basic.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_6_11_读写锁 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {

    }

    private static class SafeCache {

        private final Map<String, Object> cache = new HashMap<>();

        private final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        private final Lock readLock = reentrantReadWriteLock.readLock();

        private final Lock writeLock = reentrantReadWriteLock.writeLock();

        public Object get(String key) {
            readLock.lock();
            try {
                return cache.get(key);
            }
            finally {
                readLock.unlock();
            }
        }

        public Object put(String key, Object value) {
            writeLock.lock();
            try {
                return cache.put(key, value);
            }
            finally {
                writeLock.unlock();
            }
        }
    }
}
