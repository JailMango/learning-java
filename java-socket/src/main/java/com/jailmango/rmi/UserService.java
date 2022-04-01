package com.jailmango.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * UserService
 *
 * @author jailmango
 * @CreateDate 2019-06-20
 * @see com.jailmango.rmi
 * @since R9.0
 */
public class UserService extends UnicastRemoteObject implements IUserService {

    protected UserService() throws RemoteException {
        super();
    }

    public UserService(int port) throws RemoteException {
        super(port);
    }

    @Override
    public UserDto queryUser(Long id) throws RemoteException {
        return new UserDto(id, "Mango", 20);
    }
}
