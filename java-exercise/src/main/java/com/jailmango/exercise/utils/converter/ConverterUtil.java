package com.jailmango.exercise.utils.converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;

/**
 * ConverterUtil
 *
 * @author he.gang33
 * @CreateDate 2020/9/29
 * @see com.jailmango.exercise.utils.converter
 * @since R9.0
 */
public class ConverterUtil {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ConverterUtil ins = new ConverterUtil();

        Source source1 = new Source("src-1", "src-desc-1");
        Source source2 = new Source("src-2", "src-desc-2");
        Source source3 = new Source("src-3", "src-desc-3");
        Source source4 = new Source("src-4", "src-desc-4");
        Source source5 = new Source("src-5", "src-desc-5");

        List<Source> sourceList = new ArrayList<>();
        sourceList.add(source1);
        sourceList.add(source2);
        sourceList.add(source3);
        sourceList.add(source4);
        sourceList.add(source5);

        List<Target> targetList = convert(sourceList, Target.class);

        System.out.println(targetList.size());
    }

    protected static <E extends BaseBean, T> List<T> convert(List<E> source, Class<T> clazz)
        throws IllegalAccessException, InstantiationException {
        List<T> result = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(source)) {
            T targetObj = clazz.newInstance();
            for (E sourceObj : source) {
                BeanUtils.copyProperties(sourceObj, targetObj);
                result.add(targetObj);
            }
        }

        return result;
    }

    private static class BaseBean implements Serializable {

        protected String name;

        public BaseBean() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private static class Source extends BaseBean {

        private String desc;

        public Source() {
        }

        public Source(String name, String desc) {
            this.name = name;
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    private static class Target extends BaseBean {

        private String desc;

        public Target() {
        }

        public Target(String name, String desc) {
            this.name = name;
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
