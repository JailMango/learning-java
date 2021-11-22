package com.jailmango.spring.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller
 *
 * @author he.gang33
 * @CreateDate 2021/10/19
 * @see com.jailmango.spring.setter
 */
@RestController
@RequestMapping(value = "test")
public class Controller {

    @Autowired
    private Factory factory;

    @RequestMapping(method = RequestMethod.GET)
    public void test(String value) {
        System.out.println("....");

        List<Access> result = factory.getAccessStrategies(1L);
        System.out.println("....");
    }
}
