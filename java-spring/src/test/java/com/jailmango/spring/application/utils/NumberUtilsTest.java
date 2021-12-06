package com.jailmango.spring.application.utils;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NumberUtilsTest {

    @Autowired
    private NumberUtils numberUtils;

    @org.junit.Test
    public void add() {
        int result = numberUtils.add(1, 2);
        Assert.assertEquals(3, result);
    }

    @org.junit.Test
    public void multi() {
        int result = numberUtils.multi(1, 2);
        Assert.assertEquals(1, result);
    }
}