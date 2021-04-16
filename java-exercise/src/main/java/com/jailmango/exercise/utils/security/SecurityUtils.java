package com.jailmango.exercise.utils.security;

import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SecurityUtils
 *
 * @author he.gang33
 * @CreateDate 2019-01-10
 * @see com.jailmango.exercise.utils.security
 * @since R9.0<br>
 */
public class SecurityUtils {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SecurityUtils.class);

    /**
     * aesPwdKey
     */
    private static String aesPwdKey = "4EGJ6D9CFFA2GG9A";

    /**
     * eCipher
     */
    static Cipher eCipher = null;

    /**
     * dCipher
     */
    static Cipher dCipher = null;

    /**
     * bkey
     */
    static byte[] bkey = null;

    /**
     * biv
     */
    static byte[] biv = null;

    /**
     * paramSpec
     */
    static AlgorithmParameterSpec paramSpec = null;

    /**
     * keySpec
     */
    static SecretKey keySpec = null;

    /**
     * encoding
     */
    static String encoding = "UTF-8";

    /**
     * base64Decoder
     */
//    static BASE64Decoder base64Decoder = new BASE64Decoder();

    static {
        initialDes();
    }

    /**
     * 初始化des Description: <br>
     *
     * @author wu.mingqiang<br>
     * @taskId <br>
     *         <br>
     */
    private static void initialDes() {
//        try {
//            eCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
//            dCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
//
//            bkey = base64Decoder.decodeBuffer("SivnBF2z0IY=");
//            biv = base64Decoder.decodeBuffer("uK1EBgjPTr0=");
//            paramSpec = new IvParameterSpec(biv);
//            keySpec = new SecretKeySpec(bkey, "DES");
//
//            dCipher.init(Cipher.DECRYPT_MODE, keySpec, paramSpec);
//            eCipher.init(Cipher.ENCRYPT_MODE, keySpec, paramSpec);
//        }
//        catch (Exception e) {
//            logger.error(e.getLocalizedMessage());
//        }
    }
//
//    /**
//     * 解密
//     *
//     * @param decryptString String <br>
//     * @return String <br>
//     * @throws Exception <br>
//     */
//    public static String decrypt(String decryptString) throws Exception {
//        return SecurityUtils.dESDecrypt(decryptString);
//    }
//
//    /**
//     * 加密
//     *
//     * @param encryptString String
//     * @return String
//     * @throws Exception <br>
//     */
//    public static String encrypt(String encryptString) throws Exception {
//        return SecurityUtils.dESEncrypt(encryptString);
//    }
//
//    /**
//     * 采用DES的CBC模式进行加密，补齐方式为PKCS5Padding
//     *
//     * @param encryptString <br>
//     * @return <br>
//     */
//    public static String dESEncrypt(String encryptString) {
//        try {
//            byte[] eout = null;
//            synchronized (eCipher) {
//                eout = eCipher.doFinal(encryptString.getBytes(encoding));
//            }
//            return new BASE64Encoder().encode(eout);
//        }
//        catch (Exception e) {
//            synchronized (eCipher) {
//                try {
//                    eCipher.init(Cipher.ENCRYPT_MODE, keySpec, paramSpec);
//                }
//                catch (Exception e1) {
//                    logger.error(e1.getLocalizedMessage());
//                }
//            }
//        }
//        return null;
//    }
//
//    /**
//     * 采用DES的CBC模式进行解密，补齐方式为PKCS5Padding
//     *
//     * @param decryptString <br>
//     * @return <br>
//     */
//    public static String dESDecrypt(String decryptString) {
//        try {
//            byte[] bout = null;
//            synchronized (dCipher) {
//                bout = dCipher.doFinal(base64Decoder.decodeBuffer(decryptString));
//            }
//            return new String(bout, encoding);
//        }
//        catch (Exception e) {
//            synchronized (dCipher) {
//                try {
//                    dCipher.init(Cipher.DECRYPT_MODE, keySpec, paramSpec);
//                }
//                catch (Exception e1) {
//                    logger.error(e1.getLocalizedMessage());
//                }
//            }
//        }
//        return null;
//    }
}
