package com.jailmango.exercise.utils.network;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NetworkCase
 *
 * @author jailmango
 * @CreateDate 2020/2/18
 * @see com.jailmango.exercise.utils.network
 * @since R9.0
 */
public class NetworkCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(NetworkCase.class);

    public static void main(String[] args) throws SocketException {
        StringBuilder ipStr = new StringBuilder();

        Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
        while (netInterfaces.hasMoreElements()) {
            NetworkInterface ni = netInterfaces.nextElement();
            Enumeration<InetAddress> ips = ni.getInetAddresses();
            while (ips.hasMoreElements()) {
                InetAddress ip = ips.nextElement();
                if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && !ip.getHostAddress().contains(":")) {
                    ipStr.append(ip.getHostAddress()).append(" ");
                }
            }
        }

        logger.info("end...");
    }
}
