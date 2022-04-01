package com.jailmango.jdk.source.interview.basic;

/**
 * SortDto
 *
 * @author jailmango
 * @CreateDate 2019/11/5
 * @see com.jailmango.jdk.source.interview.basic
 * @since R9.0
 */
public class SortDto implements Comparable<SortDto> {

    /**
     * name
     */
    private String name;

    public SortDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(SortDto o) {
        return this.getName().compareTo(o.getName());
    }
}
