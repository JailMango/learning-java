package com.jailmango.exercise.utils.security;

/**
 * CoreKeyProperties
 *
 * @author jailmango
 * @CreateDate 2020/3/11
 * @see com.jailmango.exercise.utils.security
 * @since R9.0
 */
public class CoreKeyProperties {

    private String key = E7TTE4NEVZEVX6OL.jfxgzyfh("QjlFT0JBQVpEMllXWTczRQ==");

    private String rsaPwd = E7TTE4NEVZEVX6OL.jfxgzyfh("enRlc29mdCQxMjM=");

    private String rsaPubPath = E7TTE4NEVZEVX6OL.jfxgzyfh("Y2xhc3NwYXRoOnJzYWtleXMvT0NTUHVibGljS2V5LnBlbQ==");

    private String rsaPrivPath = E7TTE4NEVZEVX6OL.jfxgzyfh("Y2xhc3NwYXRoOnJzYWtleXMvT0NTUHJpdmF0ZUtleS5wZW0=");

    private int rsaKeySize = 256;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRsaPwd() {
        return rsaPwd;
    }

    public void setRsaPwd(String rsaPwd) {
        this.rsaPwd = rsaPwd;
    }

    public String getRsaPubPath() {
        return rsaPubPath;
    }

    public void setRsaPubPath(String rsaPubPath) {
        this.rsaPubPath = rsaPubPath;
    }

    public String getRsaPrivPath() {
        return rsaPrivPath;
    }

    public void setRsaPrivPath(String rsaPrivPath) {
        this.rsaPrivPath = rsaPrivPath;
    }

    public int getRsaKeySize() {
        return rsaKeySize;
    }

    public void setRsaKeySize(int rsaKeySize) {
        this.rsaKeySize = rsaKeySize;
    }
}
