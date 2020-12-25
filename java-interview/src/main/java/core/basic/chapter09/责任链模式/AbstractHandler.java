package core.basic.chapter09.责任链模式;

/**
 * AbstractHandler
 *
 * @author he.gang33
 * @CreateDate 2020/12/17
 * @see core.basic.chapter09.责任链模式
 * @since R9.0
 */
public abstract class AbstractHandler {

    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
