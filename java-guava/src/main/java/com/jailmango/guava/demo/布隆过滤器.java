package com.jailmango.guava.demo;

import java.nio.charset.Charset;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

/**
 * 布隆过滤器
 *
 * @author he.gang33
 * @CreateDate 2020/12/7
 * @see com.jailmango.guava.demo
 * @since R9.0
 */
public class 布隆过滤器 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        BloomFilter<Person> bloomFilter = BloomFilter.create(PersonFunnel.INSTANCE, 10, 0.01);

        System.out.println(bloomFilter.mightContain(new Person("chen", "yahui")));
        bloomFilter.put(new Person("chen", "yahui"));
        System.out.println(bloomFilter.mightContain(new Person("chen", "yahui")));
    }

    private static class Person {

        private String firstName;

        private String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

    private static enum PersonFunnel implements Funnel<Person> {
        /**
         * INSTANCE
         */
        INSTANCE;

        @Override
        public void funnel(Person from, PrimitiveSink into) {
            into.putString(from.getFirstName(), Charset.defaultCharset()).putString(from.getLastName(),
                Charset.defaultCharset());
        }
    }
}
