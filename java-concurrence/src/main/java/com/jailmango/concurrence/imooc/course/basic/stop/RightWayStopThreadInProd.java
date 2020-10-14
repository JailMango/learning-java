package com.jailmango.concurrence.imooc.course.basic.stop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RightWayStopWayInProd <br/>
 * Chapter5-6 <br/>
 * 最佳实践: catch了InterruptedException之后，优先选择在方法签名中抛出异常 那么在run()方法中就会强制try-catch
 * 
 * @author he.gang33
 * @CreateDate 2020/4/15
 * @see com.jailmango.concurrence.imooc.course.basic.stop
 * @since R9.0
 */
public class RightWayStopThreadInProd implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(RightWayStopThreadInProd.class);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
    }

    @Override
    public void run() {
        while (true) {
            try {
                throwInMethod();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void throwInMethod() throws InterruptedException {
        Thread.sleep(5000);
    }

    private void throwInMethod1() {
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
