package com.jailmango.rmi.server.service.impl;

import org.springframework.stereotype.Service;

import com.jailmango.rmi.entity.UserDto;
import com.jailmango.rmi.service.IUserService;

/**
 * UserServiceImpl
 *
 * @author he.gang33
 * @CreateDate 2019-07-04
 * @see com.jailmango.rmi.server.service.impl
 * @since R9.0
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Override
    public UserDto queryUser(Long id) {
        return new UserDto("Name-" + id);
    }
}
