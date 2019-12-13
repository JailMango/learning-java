package com.jailmango.exercise.utils.encode;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base64Case
 *
 * @author he.gang33
 * @CreateDate 2018-11-29
 * @see com.jailmango.exercise.utils.encode
 * @since R9.0<br>
 */
public class Base64Case {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Base64Case.class);

    /**
     * UTF-8
     */
    private static final String CHARSET_UTF_8 = "UTF-8";

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        String str = "qVhz\\/KNmC1DYmpA7KE01zuItVQn9Owz+t8i\\/3XSno6eLXgy\\/qIQ6Ljoc0ZwFFX0C1dIrJtjf0ioo\\nH0bXNy93gmlbNVf3SflfN2cpVqguTc2W\\/E20dUzxzmKGSTXdrA9sctOgQYffdsTB7PtrSs4zyF48\\nMPgLb5eGixBdzNKraSE2LsvpgQk+cT7tSpHqF9OiNlOHKkE7QSHzzHXe7yp7qi4IPjWiHu\\/VnyiN\\nWF9dd7InDGR8+Ck1+U8K8PPTLSB3JVUXyjd\\/DYqsRqBJ7H2\\/d5sTUr12c7DoApraY5JO16JnibzH\\nBBy75S+8Dt8OjUTlueKk8N\\/sGi8d3WEo39UZhRQHSZFB9JVxYAIR7kksuY1ughspKBqMCSbjba9K\\nPWMRlgM+\\/LKOHc+ZxcFNrDQEfySQufbrcBVDG\\/fXMxhR\\/Po=";

        try {
            logger.info(base64Decrypt(str));
        }
        catch (UnsupportedEncodingException e) {
            logger.error(e.getLocalizedMessage());
        }

    }

    /**
     * 加密
     * 
     * @param encryptString String
     * @return String
     * @throws UnsupportedEncodingException UnsupportedEncodingException
     */
    public static String base64Encrypt(String encryptString) throws UnsupportedEncodingException {
        return new String(Base64.encodeBase64(encryptString.getBytes(CHARSET_UTF_8)), CHARSET_UTF_8);
    }

    /**
     * 解密
     * 
     * @param decryptString String
     * @return String
     * @throws UnsupportedEncodingException UnsupportedEncodingException
     */
    public static String base64Decrypt(String decryptString) throws UnsupportedEncodingException {
        return new String(Base64.decodeBase64(decryptString.getBytes(CHARSET_UTF_8)), CHARSET_UTF_8);
    }
}
