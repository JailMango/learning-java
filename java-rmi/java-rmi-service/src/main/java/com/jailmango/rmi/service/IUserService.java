package com.jailmango.rmi.service;

import com.jailmango.rmi.entity.UserDto;

/**
 * IUserService
 *
 * @author jailmango
 * @CreateDate 2019-07-03
 * @see com.jailmango.rmi.service
 * @since R9.0
 */
public interface IUserService {

    /**
     * queryUser
     * 
     * @param id Long
     * @return UserDto
     */
    UserDto queryUser(Long id);
}
