package com.jailmango.exercise.utils.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * ParseUtil
 *
 * @author he.gang33
 * @CreateDate 2020/4/17
 * @see com.jailmango.exercise.utils.string
 * @since R9.0
 */
public class ParseUtil {

    /**
     * MSG_SESSION_ID
     */
    public static final int MSG_SESSION_ID = 0;

    /**
     * MSG_RESULT_CODE
     */
    public static final int MSG_RESULT_CODE = 2;

    /**
     * MSG_VERSION_ID
     */
    public static final int MSG_VERSION_ID = 3;

    /**
     * //创建的共享内存大小(单位：M）
     */
    public static final int MSG_MEM_SIZE = 7;

    /**
     * MSG_PROC_MEM1
     */
    public static final int MSG_PROC_MEM1 = 11;

    /**
     * MSG_PROC_MEM2
     */
    public static final int MSG_PROC_MEM2 = 160;

    /**
     * MSG_RET_SUCCESS// 成功
     */
    public static final int MSG_RET_SUCCESS = 0;

    /**
     * MSG_RET_FAILD// 失败
     */
    public static final int MSG_RET_FAILD = 1;

    /**
     * MSG_RET_QUERY_FAILD// 查询失败
     */
    public static final int MSG_RET_QUERY_FAILD = 2;

    /**
     * // 刷新失败
     */
    public static final int MSG_RET_RFRSH_FAILD = 3;

    /**
     * // 加载失败
     */
    public static final int MSG_RET_ADD_FAILD = 4;

    /**
     * // 删除失败
     */
    public static final int MSG_RET_DEL_FAILD = 5;

    /**
     * // 不存在指定进程
     */
    public static final int MSG_RET_NO_PROCESS = 6;

    /**
     * // 不存在该配置资料版本
     */
    public static final int MSG_RET_NO_VERSION = 7;

    /**
     * // 删除共享内存失败；
     */
    public static final int MSG_RET_EXP_FAILD = 8;

    /**
     * // 解析消息失败；
     */
    public static final int MSG_RET_PARSE_FAILD = 9;

    /**
     * // 组消息包失败；
     */
    public static final int MSG_RET_ENCODE_FAILD = 10;

    /**
     * // 资费尚有进程连接
     */
    public static final int MSG_RET_ATTATCHED_MEM = 11;

    /**
     * // 无效的共享内存大小(有效值:500M >= MemSize >= 40M)
     */
    public static final int MSG_RET_INVALID_MEMSIZE = 12;

    /**
     * SPLIT_TAG
     */
    public static final String SPLIT_TAG = "|";

    /**
     * 分割字符串 <Description> split
     *
     * @return String[]
     * @param line line
     * @param separator separator
     */
    public static String[] split(String line, String separator) {
        LinkedList list = new LinkedList();
        if (line != null) {
            int start = 0;
            int end = 0;
            int separatorLen = separator.length();
            while ((end = line.indexOf(separator, start)) >= 0) {
                list.add(line.substring(start, end));
                start = end + separatorLen;
            }
            if (start < line.length()) {
                list.add(line.substring(start, line.length()));
            }
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    public static Map<String, Object> buildRulePlanVersion(String field) {
        Map<String, Object> version = new HashMap<>();
        String[] sArr = ParseUtil.split(field, ",");
        System.out.println("PID: [" + sArr[0] + "] -> Size: [" + sArr.length + "]");
        int loop = 0;
        version.put("OS_PID", sArr[loop++]);
        version.put("ZXOS_PID", sArr[loop++]);
        version.put("RNAME", sArr[loop++]);
        version.put("RulePlanVersion", sArr[loop++]);
        version.put("UPDATE_DATE", sArr[loop++]);
        version.put("MEMORY_CAPICATION", sArr[loop++]);
        return version;
    }

    public static Map<String, Object> executeResponse(String response, Map<String, Object> dict,
        boolean isExecuteResultCode) {
        String[] values = null;
        String temp = response;
        values = ParseUtil.split(temp, SPLIT_TAG);
        if (values != null && values.length != 0) {
            for (int loop = 0; loop < values.length; loop++) {
                eachExecuteResponse(dict, isExecuteResultCode, values, loop);
            }
        }
        return dict;
    }

    public static void eachExecuteResponse(Map<String, Object> dict, boolean isExecuteResultCode, String[] values,
        int loop) {
        String expression = values[loop];
        int equalIndex = expression.indexOf('=');
        int key = Integer.parseInt(expression.substring(0, equalIndex));

        switch (key) {
            case ParseUtil.MSG_SESSION_ID: {
                break;
            }
            case ParseUtil.MSG_RESULT_CODE: {
                String sValue = expression.substring(equalIndex + 1);
                int iValue = Integer.parseInt(sValue);
                if (isExecuteResultCode) {
                    executeResultCode(iValue);
                }
                dict.put("RESULT_CODE", sValue);
                break;
            }
            case ParseUtil.MSG_VERSION_ID: {
                String sValue = expression.substring(equalIndex + 1);
                dict.put("PVERSION_ID", sValue);
                break;
            }
            case ParseUtil.MSG_MEM_SIZE: {
                String sValue = expression.substring(equalIndex + 1);
                dict.put("MSG_MEM_SIZE", sValue);
                break;
            }
            default: {
                if (key >= ParseUtil.MSG_PROC_MEM1 && key <= ParseUtil.MSG_PROC_MEM2) {
                    String sValue = expression.substring(equalIndex + 1);
                    dict.put("RESPONSE", ParseUtil.buildRulePlanVersion(sValue));
                }
                else {
                    // Ignore
                }
            }
        }
    }

    public static void executeResultCode(int value) {
        // 设置报错信息键值对
        Map<Integer, String> params = new HashMap<Integer, String>();
        params.put(MSG_RET_FAILD, "S-PCC-10116");
        params.put(MSG_RET_QUERY_FAILD, "S-PCC-10117");
        params.put(MSG_RET_RFRSH_FAILD, "S-PCC-10118");
        params.put(MSG_RET_ADD_FAILD, "S-PCC-10119");
        params.put(MSG_RET_DEL_FAILD, "S-PCC-10120");
        params.put(MSG_RET_NO_PROCESS, "S-PCC-10121");
        params.put(MSG_RET_NO_VERSION, "S-PCC-10122");
        params.put(MSG_RET_EXP_FAILD, "S-PCC-10123");
        params.put(MSG_RET_PARSE_FAILD, "S-PCC-10124");
        params.put(MSG_RET_ENCODE_FAILD, "S-PCC-10125");
        params.put(MSG_RET_ATTATCHED_MEM, "S-PCC-10126");
        params.put(MSG_RET_INVALID_MEMSIZE, "S-PCC-10127");
        if (params.containsKey(value)) {
            // 获取错误码
            String errCodeMsg = params.get(value);
            System.out.println("ErrCode: [" + errCodeMsg + "]");
        }
        else if (MSG_RET_SUCCESS == value) {
            // 不处理
        }
        else {
            // 不处理
        }
    }

    public static void main(String[] args) {
        Map<String, Object> dict = new HashMap<>();
        String response = "0=4808|2=0|11=48461,220,OCRuleMgr 220,3734,20200217161554,100|12=48461,220,OCRuleMgr 220,3735,20200228110912,100|13=48461,220,OCRuleMgr 220,3736,20200303234246,100|14=48461,220,OCRuleMgr 220,3738,20200317211038,100|15=48461,220,OCRuleMgr 220,3739,20200407213520,100|16=48461,220,OCRuleMgr 220,3740,20200414222300,100|17=47590,-1,PCdrInDB -p /jktpcrf/data/output/normal,3741,20200417021704,100|18=47610,-1,PCdrInDB -p /jktpcrf/data/abnormal_cdr,3741,20200417021704,100|19=47635,-1,PCdrInDB -p /jktpcrf/data/output/sbynormal,3741,20200417021704,100|20=47660,-1,PCdrInDB -p /jktpcrf/data/sbyabnormal_cdr,3741,20200417021704,100|21=48663,304,PDE 304 23 253 400,3741,20200417021704,100|22=48511,254,pdr_writer 254 0,3741,20200417021704,100|23=48524,301,PDE 301 23 253 400,3741,20200417021704,100|24=48837,346,afdeal 346 27 254 401,3741,20200417021704,100|25=48449,253,pdr_writer 253 0 1,3741,20200417021704,100|26=48587,340,afdeal 340 27 253 400,3741,20200417021704,100|27=48536,302,PDE 302 23 254 401,3741,20200417021704,100|28=48479,300,PDE 300 23 253 400,3741,20200417021704,100|29=48629,342,afdeal 342 27 253 401,3741,20200417021704,100|30=48743,308,PDE 308 23 253 401,3741,20200417021704,100|31=48646,343,afdeal 343 27 253 401,3741,20200417021704,100|32=48705,306,PDE 306 23 254 401,3741,20200417021704,100|33=48599,341,afdeal 341 27 253 400,3741,20200417021704,100|34=48720,307,PDE 307 23 253 401,3741,20200417021704,100|35=48688,305,PDE 305 23 254 401,3741,20200417021704,100|36=48782,310,PDE 310 23 254 400,3741,20200417021704,100|37=48763,309,PDE 309 23 254 400,3741,20200417021704,100|38=48806,344,afdeal 344 27 254 400,3741,20200417021704,100|39=48821,345,afdeal 345 27 254 401,3741,20200417021704,100|40=48554,303,PDE 303 23 254 401,3741,20200417021704,100|41=83466,210,AbnSessionMgr 210,3741,20200417021704,100|42=112458,310,PDE 310 23 254 400,3741,20200417021704,100|43=129628,310,PDE 310 23 254 400,3741,20200417021704,100|44=15329,306,PDE 306 23 254 401,3741,20200417021704,100|45=16566,310,PDE 310 23 254 400,3741,20200417021704,100|46=33728,306,PDE 306 23 254 401,3741,20200417021704,100|47=34628,310,PDE 310 23 254 400,3741,20200417021704,100|48=43953,302,PDE 302 23 254 401,3741,20200417021704,100|49=51016,306,PDE 306 23 254 401,3741,20200417021704,100|50=52127,310,PDE 310 23 254 400,3741,20200417021704,100|51=61219,302,PDE 302 23 254 401,3741,20200417021704,100|52=68686,306,PDE 306 23 254 401,3741,20200417021704,100|53=69344,310,PDE 310 23 254 400,3741,20200417021704,100|54=85491,306,PDE 306 23 254 401,3741,20200417021704,100|55=86576,310,PDE 310 23 254 400,3741,20200417021704,100|56=92811,307,PDE 307 23 253 401,3741,20200417021704,100|57=102761,306,PDE 306 23 254 401,3741,20200417021704,100|58=103708,310,PDE 310 23 254 400,3741,20200417021704,100|59=119627,306,PDE 306 23 254 401,3741,20200417021704,100|60=120778,310,PDE 310 23 254 400,3741,20200417021704,100|61=6604,306,PDE 306 23 254 401,3741,20200417021704,100|62=7760,310,PDE 310 23 254 400,3741,20200417021704,100|63=27527,306,PDE 306 23 254 401,3741,20200417021704,100|64=28459,310,PDE 310 23 254 400,3741,20200417021704,100|65=43802,307,PDE 307 23 253 401,3741,20200417021704,100|66=45871,306,PDE 306 23 254 401,3741,20200417021704,100|67=46525,310,PDE 310 23 254 400,3741,20200417021704,100|68=62867,306,PDE 306 23 254 401,3741,20200417021704,100|69=63566,310,PDE 310 23 254 400,3741,20200417021704,100|70=81511,306,PDE 306 23 254 401,3741,20200417021704,100|71=82221,310,PDE 310 23 254 400,3741,20200417021704,100|72=98624,306,PDE 306 23 254 401,3741,20200417021704,100|73=99017,310,PDE 310 23 254 400,3741,20200417021704,100|74=116205,306,PDE 306 23 254 401,3741,20200417021704,100|75=116882,310,PDE 310 23 254 400,3741,20200417021704,100|76=2610,306,PDE 306 23 254 401,3741,20200417021704,100|77=3364,310,PDE 310 23 254 400,3741,20200417021704,100|78=20304,306,PDE 306 23 254 401,3741,20200417021704,100|79=21134,310,PDE 310 23 254 400,3741,20200417021704,100|80=37826,306,PDE 306 23 254 401,3741,20200417021704,100|81=38640,310,PDE 310 23 254 400,3741,20200417021704,100|82=55563,306,PDE 306 23 254 401,3741,20200417021704,100|83=56111,310,PDE 310 23 254 400,3741,20200417021704,100|84=72255,310,PDE 310 23 254 400,3741,20200417021704,100|85=73688,306,PDE 306 23 254 401,3741,20200417021704,100|86=90039,306,PDE 306 23 254 401,3741,20200417021704,100|87=90774,310,PDE 310 23 254 400,3741,20200417021704,100|88=107250,306,PDE 306 23 254 401,3741,20200417021704,100|89=107969,308,PDE 308 23 253 401,3741,20200417021704,100|90=108369,310,PDE 310 23 254 400,3741,20200417021704,100|91=124560,306,PDE 306 23 254 401,3741,20200417021704,100|92=124946,310,PDE 310 23 254 400,3741,20200417021704,100|93=11401,306,PDE 306 23 254 401,3741,20200417021704,100|94=11753,310,PDE 310 23 254 400,3741,20200417021704,100|95=28379,306,PDE 306 23 254 401,3741,20200417021704,100|96=29023,310,PDE 310 23 254 400,3741,20200417021704,100|97=45569,306,PDE 306 23 254 401,3741,20200417021704,100|98=46195,310,PDE 310 23 254 400,3741,20200417021704,100|99=62738,306,PDE 306 23 254 401,3741,20200417021704,100|100=63374,310,PDE 310 23 254 400,3741,20200417021704,100|101=80445,306,PDE 306 23 254 401,3741,20200417021704,100|102=80856,310,PDE 310 23 254 400,3741,20200417021704,100|103=97405,310,PDE 310 23 254 400,3741,20200417021704,100|104=98361,306,PDE 306 23 254 401,3741,20200417021704,100|105=107181,302,PDE 302 23 254 401,3741,20200417021704,100|106=114846,310,PDE 310 23 254 400,3741,20200417021704,100|107=115688,306,PDE 306 23 254 401,3741,20200417021704,100|108=124742,302,PDE 302 23 254 401,3741,20200417021704,100|109=2060,306,PDE 306 23 254 401,3741,20200417021704,100|110=2595,310,PDE 310 23 254 400,3741,20200417021704,100|111=11205,302,PDE 302 23 254 401,3741,20200417021704,100|112=19360,306,PDE 306 23 254 401,3741,20200417021704,100|113=19762,310,PDE 310 23 254 400,3741,20200417021704,100|114=28677,302,PDE 302 23 254 401,3741,20200417021704,100|115=36144,310,PDE 310 23 254 400,3741,20200417021704,100|116=37163,306,PDE 306 23 254 401,3741,20200417021704,100|117=45813,302,PDE 302 23 254 401,3741,20200417021704,100|118=54011,306,PDE 306 23 254 401,3741,20200417021704,100|119=54715,310,PDE 310 23 254 400,3741,20200417021704,100|120=63087,302,PDE 302 23 254 401,3741,20200417021704,100|121=70684,310,PDE 310 23 254 400,3741,20200417021704,100|122=71654,306,PDE 306 23 254 401,3741,20200417021704,100|123=80505,302,PDE 302 23 254 401,3741,20200417021704,100|124=87994,306,PDE 306 23 254 401,3741,20200417021704,100|125=88766,310,PDE 310 23 254 400,3741,20200417021704,100|126=97603,302,PDE 302 23 254 401,3741,20200417021704,100|127=105636,306,PDE 306 23 254 401,3741,20200417021704,100|128=106059,310,PDE 310 23 254 400,3741,20200417021704,100|129=122797,306,PDE 306 23 254 401,3741,20200417021704,100|130=123238,310,PDE 310 23 254 400,3741,20200417021704,100|131=9502,306,PDE 306 23 254 401,3741,20200417021704,100|132=9986,310,PDE 310 23 254 400,3741,20200417021704,100|133=27064,306,PDE 306 23 254 401,3741,20200417021704,100|134=27746,310,PDE 310 23 254 400,3741,20200417021704,100|135=44058,306,PDE 306 23 254 401,3741,20200417021704,100|136=44836,310,PDE 310 23 254 400,3741,20200417021704,100|137=60421,302,PDE 302 23 254 401,3741,20200417021704,100|138=62077,306,PDE 306 23 254 401,3741,20200417021704,100|139=62508,310,PDE 310 23 254 400,3741,20200417021704,100|140=79058,306,PDE 306 23 254 401,3741,20200417021704,100|141=79504,310,PDE 310 23 254 400,3741,20200417021704,100|142=96420,306,PDE 306 23 254 401,3741,20200417021704,100|143=96902,310,PDE 310 23 254 400,3741,20200417021704,100|144=113612,306,PDE 306 23 254 401,3741,20200417021704,100|145=114325,310,PDE 310 23 254 400,3741,20200417021704,100|146=130686,306,PDE 306 23 254 401,3741,20200417021704,100|147=988,310,PDE 310 23 254 400,3741,20200417021704,100|148=17363,306,PDE 306 23 254 401,3741,20200417021704,100|149=18076,310,PDE 310 23 254 400,3741,20200417021704,100|150=22655,302,PDE 302 23 254 401,3741,20200417021704,100|151=31879,310,PDE 310 23 254 400,3741,20200417021704,100|152=34608,306,PDE 306 23 254 401,3741,20200417021704,100|153=35286,310,PDE 310 23 254 400,3741,20200417021704,100|154=39812,30";
        ParseUtil.executeResponse(response, dict, true);
    }
}