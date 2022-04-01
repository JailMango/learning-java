package com.jailmango.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * IUserService
 *
 * @author jailmango
 * @CreateDate 2019-06-20
 * @see com.jailmango.rmi
 * @since R9.0
 */
public interface IUserService extends Remote {

    UserDto queryUser(Long id) throws RemoteException;
}
