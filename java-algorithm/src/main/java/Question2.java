/**
 * Question2 - 最大公约数，最小公倍数
 *
 * @author gang.he2
 * @CreateDate 2022/4/12
 */
public class Question2 {

    /**
     * 最大公约数
     *
     * @param a 正整数a
     * @param b 正整数b
     * @return int
     */
    public static int maxDivide(int a, int b) throws Exception {
        if (!isValidParams(a, b)) {
            throw new RuntimeException("Invalid Parameters.");
        }

        // 1. 取余结结果 2.用作数值交换
        int result = 0;

        // 数值校验，a > b
        if (a < b) {
            result = a;
            a = b;
            b = result;
        }

        while ((result = a % b) != 0) {
            a = b;
            b = result;
        }

        return b;
    }

    /**
     * 最小公倍数
     *
     * @param a 正整数a
     * @param b 正整数b
     * @return int
     */
    public static int minMulti(int a, int b) throws Exception {
        if (!isValidParams(a, b)) {
            throw new RuntimeException("Invalid Parameters.");
        }

        int maxDivideNum = maxDivide(a, b);

        return a * b / maxDivideNum;
    }

    /**
     * 校验参数是否均为正整数 <br/>
     * true - 通过校验，false - 未通过校验
     *
     * @param a 参数a
     * @param b 参数b
     * @return boolean
     */
    private static boolean isValidParams(int a, int b) {
        if (a < 0 || b < 0) {
            return false;
        }

        return true;
    }
}
