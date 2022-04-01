package async.chapter02;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * C2_1_显示的使用
 *
 * @author jailmango
 * @see async.chapter02
 */
@Slf4j
public class C2_1_显示的使用 {

    /**
     * main
     *
     * @param args
     *            String[]
     */
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(0L, "0-Name"));
        list.add(new Person(1L, "1-Name"));
        list.add(new Person(2L, "2-Name"));
        list.add(new Person(3L, "3-Name"));
        list.add(new Person(4L, "4-Name"));
        list.add(new Person(5L, "5-Name"));
        list.add(new Person(7L, "7-Name"));
        list.add(new Person(8L, "8-Name"));
        list.add(new Person(9L, "9-Name"));

        List<Long> idList = new ArrayList<>();
        idList.add(0L);
        idList.add(1L);
        idList.add(2L);
        idList.add(3L);
        idList.add(4L);
        idList.add(5L);
        idList.add(7L);
        idList.add(8L);
        idList.add(9L);


        List<Person> list1 = new ArrayList<>();
        list1.add(new Person(2L, "2-Name"));
        list1.add(new Person(4L, "4-Name"));
        list1.add(new Person(6L, "6-Name"));
        list1.add(new Person(8L, "8-Name"));
        list1.add(new Person(10L, "10-Name"));


       Map<Long, Person> map = list1.stream().filter(person -> idList.contains(person.getAge())).collect(Collectors.toMap(Person::getAge, Function.identity(), (oldValue, newValue) -> newValue));

        boolean result = false;

        int count = 0;

//        for (Long ele : list1) {
//            result = list.contains(ele);
//
//            if (result) {
//                log.info("{}", ++count);
//            }
//        }

        log.info("end...");
    }

    private static class Person {

        public Person(Long age, String name) {
            this.age = age;
            this.name = name;
        }

        private Long age;

        private String name;

        public Long getAge() {
            return age;
        }

        public void setAge(Long age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
