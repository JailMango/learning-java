package core.basic.chapter09.责任链模式;

/**
 * 责任链模式
 *
 * @author he.gang33
 * @CreateDate 2020/12/17
 * @see core.basic.chapter09.责任链模式
 * @since R9.0
 */
public class 责任链模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        AuthHandler authHandler = new AuthHandler("auth");
        BussinessHandler bussinessHandler = new BussinessHandler("bussiness");
        ResponseHandler responseHandler = new ResponseHandler("response");
        authHandler.setHandler(bussinessHandler);
        bussinessHandler.setHandler(responseHandler);

        authHandler.operator();
    }
}
