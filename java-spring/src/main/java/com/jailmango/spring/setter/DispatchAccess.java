package com.jailmango.spring.setter;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * RateAccess
 *
 * @author he.gang33
 * @CreateDate 2021/10/19
 * @see com.jailmango.spring.setter
 */
@Component
public class DispatchAccess extends AbstractAccess {

    /**
     * 适配的场景
     */
    private static Set<Long> supportScenes;

    static {
        supportScenes = new HashSet<>();
        supportScenes.add(1L);
    }

    @Override
    public Set<Long> supportScene() {
        return supportScenes;
    }

    @Override
    public void log() {
        System.out.println("dispatch");
    }
}
