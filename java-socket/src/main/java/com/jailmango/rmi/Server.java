package com.jailmango.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Server
 *
 * @author he.gang33
 * @CreateDate 2019-06-20
 * @see com.jailmango.rmi
 * @since R9.0
 */
public class Server {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) {
        try {
            java.rmi.registry.Registry registry = LocateRegistry.createRegistry(1099);
            IUserService service = new UserService();
            registry.bind("rmi://localhost:1099/user", service);
        }
        catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
