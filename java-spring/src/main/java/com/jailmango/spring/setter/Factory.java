package com.jailmango.spring.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Factory
 *
 * @author he.gang33
 * @CreateDate 2021/10/19
 * @see com.jailmango.spring.setter
 */
@Component
public class Factory {

    private List<Access> accesses;

    @Autowired
    public void setAccesses(List<Access> accesses) {
        this.accesses = accesses;
    }

    public List<Access> getAccessStrategies(Long scene) {
        return accesses.stream().filter(access -> access.supportScene().contains(scene)).collect(Collectors.toList());
    }
}
