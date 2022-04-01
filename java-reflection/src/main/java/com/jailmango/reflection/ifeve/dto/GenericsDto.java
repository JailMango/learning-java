package com.jailmango.reflection.ifeve.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * GenericsDto
 *
 * @author jailmango
 * @CreateDate 2019-04-19
 * @see com.jailmango.reflection.ifeve.dto
 * @since R9.0
 */
public class GenericsDto {

    /**
     * list
     */
    public List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
