package com.jailmango.concurrence.book.action.chapter05;

import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_5_2_Future模式的简单实现
 *
 * @author jailmango
 * @CreateDate 2020/10/23
 * @see com.jailmango.concurrence.book.action.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_5_2_Future模式的简单实现 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        Data data = client.request("request-1");
        log.info("请求完毕...");
        log.info("没有结果...");
        Thread.sleep(2000);
        log.info("结果[{}]", data.getResult());
    }

    private static class Client {

        public Data request(String value) {
            final FutureData future = new FutureData();
            new Thread(() -> {
                RealData realData = new RealData(value);
                future.setRealData(realData);
            }).start();
            return future;
        }
    }

    private static class FutureData implements Data {

        protected RealData realData;

        protected boolean isReady = false;

        public synchronized void setRealData(RealData realData) {
            if (isReady) {
                return;
            }

            this.realData = realData;
            isReady = true;
            notifyAll();
        }

        @Override
        public synchronized String getResult() {
            while (!isReady) {
                try {
                    wait();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return realData.result;
        }
    }

    private static class RealData implements Data {

        protected final String result;

        public RealData(String initVal) {
            StringBuffer sb = new StringBuffer(initVal);
            for (int i = 0; i < 10; i++) {
                sb.append(i);
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.result = sb.toString();
        }

        @Override
        public String getResult() {
            return this.result;
        }
    }

    private static interface Data {

        String getResult();
    }
}
