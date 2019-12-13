package com.jailmango.exercise.utils.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * StringAndHex - 字符串与16进制转换
 *
 * @author he.gang33
 * @CreateDate 2019-01-03
 * @see com.jailmango.exercise.utils.string
 * @since R9.0<br>
 */
public class StringAndHex {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(StringAndHex.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        // byte[] arr = hexString2Bytes("dc00");
        // String a = hexString2String("00");
        // logger.info("{}", a);
        //
        // char c = (char) Integer.valueOf("0000", 16).byteValue();
        // char c = (char) Integer.reverseBytes(Integer.valueOf("0000", 16));
        // logger.info("{}", c);
        //Caller
        // Integer port = 37344;

        int i = Integer.reverseBytes(357);

        String str = Integer.toHexString(i);
        logger.info("{}", str);
    }

    private void case1() {
        logger.info(hexString2String(
            "2263617272696572506f737444617461223a227156687a5c2f4b4e6d433144596d7041374b4530317a75497456516e394f777a2b7438695c2f3358536e6f36654c5867795c2f714951364c6a6f63305a774646583043316449724a746a6630696f6f5c6e483062584e793933676d6c624e56663353666c664e32637056716775546332575c2f45323064557a787a6d4b47535458647241397363744f675159666664735442375074725373347a794634385c6e4d50674c62356547697842647a4e4b72615345324c73767067516b2b635437745370487146394f694e6c4f484b6b45375153487a7a4858653779703771693449506a576948755c2f566e79694e5c6e574639646437496e444752382b436b312b55384b385050544c5342334a565558796a645c2f445971735271424a3748325c2f64357354557231326337446f4170726159354a4f31364a6e69627a485c6e4242793735532b384474384f6a55546c75654b6b384e5c2f73476938643357456f3339555a68525148535a4642394a567859414952376b6b7375593175676873704b42714d4353626a6261394b5c6e50574d526c674d2b5c2f4c4b4f48632b5a7863464e72445145667953517566627263425644475c2f66584d7868525c2f506f3d22"));
    }

    /**
     * bytes2HexString
     * 
     * @param b byte[]
     * @return String
     */
    public static String bytes2HexString(byte[] b) {
        StringBuffer result = new StringBuffer();
        String hex;
        for (int i = 0; i < b.length; i++) {
            hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            result.append(hex.toUpperCase());
        }
        return result.toString();
    }

    /**
     * hexString2Bytes
     * 
     * @param src String
     * @return byte[]
     */
    public static byte[] hexString2Bytes(String src) {
        int l = src.length() / 2;
        byte[] ret = new byte[l];
        for (int i = 0; i < l; i++) {
            ret[i] = Integer.valueOf(src.substring(i * 2, i * 2 + 2), 16).byteValue();
        }
        return ret;
    }

    /**
     * string2HexString
     * 
     * @param strPart String
     * @return String
     */
    public static String string2HexString(String strPart) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < strPart.length(); i++) {
            int ch = (int) strPart.charAt(i);
            String strHex = Integer.toHexString(ch);
            hexString.append(strHex);
        }
        return hexString.toString();
    }

    /**
     * hexString2String
     * 
     * @param src String
     * @return String
     */
    public static String hexString2String(String src) {
        String temp = "";
        for (int i = 0; i < src.length() / 2; i++) {
            temp = temp + (char) Integer.valueOf(src.substring(i * 2, i * 2 + 2), 16).byteValue();
        }
        return temp;
    }

    /**
     * char2Byte
     * 
     * @param src Character
     * @return Byte
     */
    public static Byte char2Byte(Character src) {
        return Integer.valueOf((int) src).byteValue();
    }

    /**
     * intToHexString
     * 
     * @param a int
     * @param len int
     * @return String
     */
    private static String intToHexString(int a, int len) {
        len <<= 1;
        String hexString = Integer.toHexString(a);
        int b = len - hexString.length();
        if (b > 0) {
            for (int i = 0; i < b; i++) {
                hexString = "0" + hexString;
            }
        }
        return hexString;
    }
}
