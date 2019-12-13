package com.jailmango.exercise.utils.ip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * IpCase
 *
 * @author he.gang33
 * @CreateDate 2019-03-06
 * @see com.jailmango.exercise.utils.ip
 * @since R9.0
 */
public class IpCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(IpCase.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        String startIp = "0.0.0.0";
        logger.info(String.valueOf(ipAddrToLong(startIp)));

        startIp = "0.0.0.0";
        logger.info(String.valueOf(ipAddrToLong(startIp)));
    }

    private static Long ipAddrToLong(String ip) {
        if (null != ip && !"".equals(ip)) {
            String[] arr = ip.split("\\.");
            return (Long.parseLong(arr[0]) << 24) + (Long.parseLong(arr[1]) << 16) + (Long.parseLong(arr[2]) << 8)
                + Long.parseLong(arr[3]);
        }
        else {
            return null;
        }
    }

    private static String longToIpAddr(Long ip) {
        StringBuffer sb = new StringBuffer();
        sb.append((ip >>> 24));
        sb.append(".");
        sb.append((ip >>> 16 & 255));
        sb.append(".");
        sb.append((ip >>> 8 & 255));
        sb.append(".");
        sb.append((ip & 255));
        return sb.toString();
    }
}
