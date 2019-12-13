package com.jailmango.netty.demo;

import java.io.Serializable;

/**
 * BaseMessage
 *
 * @author he.gang33
 * @CreateDate 2019-06-12
 * @see com.jailmango.netty.demo
 * @since R9.0
 */
public abstract class BaseMessage implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -5800485728367112546L;

    private MessageType type;

    private String clientId;

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
