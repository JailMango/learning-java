package com.jailmango.netty.demo;

/**
 * LoginMessage
 *
 * @author he.gang33
 * @CreateDate 2019-06-12
 * @see com.jailmango.netty.demo
 * @since R9.0
 */
public class LoginMessage extends BaseMessage {

    private String username;

    private String password;

    public LoginMessage() {
        super();
        setType(MessageType.LOGIN);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
