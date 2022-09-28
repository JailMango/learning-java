import com.jailmango.algorithm.FeeTypeEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Person
 *
 * @author gang.he2
 * @CreateDate 2022/4/12
 * @see PACKAGE_NAME
 */
@Slf4j
public class Person {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {

        String str = "TON";

        for (FeeTypeEnum feeTypeEnum : FeeTypeEnum.values()) {
            System.out.println(feeTypeEnum.name());

            if (feeTypeEnum.name().equals(str)) {
                int a = 1;
            }
        }

        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};

        Iterator<Integer> iterator = list.iterator();
        int  target = 3;
        boolean removed = false;

        while (iterator.hasNext()) {
            Integer tmp = iterator.next();

            if (Objects.equals(tmp, target)) {
                iterator.remove();
                removed = true;
                break;
            }
        }
        if (removed) {
            list.add(0, target);
        }
        else {
            // 直接设置到第一位
            list.set(0, target);
        }

        int a = 1;
    }
}
