package com.jailmango.exercise.utils.optional;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

/**
 * OptionalCase
 *
 * @author he.gang33
 * @CreateDate 2021/11/16
 * @see com.jailmango.exercise.utils.optional
 */
@Slf4j
public class OptionalCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        List<Long> l1 = null;
        List<Long> l2 = Lists.newArrayList(1L, 2L);

        List<Long> l3 = Optional.ofNullable(l1).orElse(Lists.newArrayList());
        List<Long> l4 = Optional.ofNullable(l2).orElse(Lists.newArrayList());

        Person p = null;
        Person p1 = Person.builder().age(199).build();

        Integer age = Optional.ofNullable(p1).map(Person::getAge).orElse(-100);
        Integer age1 = Optional.ofNullable(p).map(Person::getAge).orElse(-123);

        try {
            String str = null;
            Optional.ofNullable(str).orElseThrow(() -> new RuntimeException("optional exception."));
        } catch (Exception e) {
            log.error("catch exception.", e);
        }

        log.info("end...");
    }

    @Data
    @Builder
    private static class Person {

        private Integer age;

        /**
         * @return
         */
        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
