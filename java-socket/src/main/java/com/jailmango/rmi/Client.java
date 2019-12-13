package com.jailmango.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client
 *
 * @author he.gang33
 * @CreateDate 2019-06-20
 * @see com.jailmango.rmi
 * @since R9.0
 */
public class Client {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            IUserService service = (IUserService) registry.lookup("rmi://localhost:1099/user");
            UserDto user = service.queryUser(1L);
            logger.info("Id:[{}], Name:[{}], Age:[{}]", user.getId(), user.getName(), user.getAge());
        }
        catch (NotBoundException | RemoteException e) {
            e.printStackTrace();
        }

    }

}
