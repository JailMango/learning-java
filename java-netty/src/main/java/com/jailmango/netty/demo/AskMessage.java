package com.jailmango.netty.demo;

/**
 * AskMessage
 *
 * @author he.gang33
 * @CreateDate 2019-06-12
 * @see com.jailmango.netty.demo
 * @since R9.0
 */
public class AskMessage extends BaseMessage {

    private AskParam askParam;

    public AskMessage() {
        super();
        setType(MessageType.ASK);
    }

    public AskParam getAskParam() {
        return askParam;
    }

    public void setAskParam(AskParam askParam) {
        this.askParam = askParam;
    }
}
