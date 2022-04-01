package com.jailmango.concurrence.book.core.chapter06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 6.4 序列化与反序列化的单例模式
 *
 * @author jailmango
 * @CreateDate 2020/8/31
 * @see com.jailmango.concurrence.book.core.chapter06
 * @since R9.0
 */
public class Case6_4 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case6_4.class);

    /**
     * filePath
     */
    private static final String FILE_PATH = "/Users/mango/Documents/repository/github/learning/learning-java/java-concurrence/src/main/resources/UserInfo-serialize.txt";

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        try {
            MyObject myObject = MyObject.getInstance();
            logger.info("序列化-myObject:[{}], userInfo:[{}]", myObject.hashCode(), myObject.userInfo.hashCode());
            FileOutputStream fos = new FileOutputStream(new File(FILE_PATH));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(myObject);
            oos.flush();
            fos.flush();
            oos.close();
            fos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream(new File(FILE_PATH));
            ObjectInputStream ois = new ObjectInputStream(fis);
            MyObject myObject = (MyObject) ois.readObject();
            ois.close();
            fis.close();
            logger.info("反序列化-myObject:[{}], userInfo:[{}]", myObject.hashCode(), myObject.userInfo.hashCode());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static class MyObject implements Serializable {

        private static final long serialVersionUID = 4059480901002733517L;

        public static UserInfo userInfo = new UserInfo();

        private static MyObject myObject = new MyObject();

        private MyObject() {

        }

        public static MyObject getInstance() {
            return myObject;
        }

        /**
         * 反序列化时，这么写可以保证单例
         * 
         * @return Object
         */
        protected Object readResolve() {
            return MyObject.myObject;
        }

    }

    private static class UserInfo implements Serializable {

        private static final long serialVersionUID = 1817342344035566384L;

        /**
         * userName
         */
        private String userName;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
