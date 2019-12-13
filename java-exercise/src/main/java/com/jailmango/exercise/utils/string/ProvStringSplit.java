package com.jailmango.exercise.utils.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ProvStringSplit
 *
 * @author he.gang33
 * @CreateDate 2019-07-23
 * @see com.jailmango.exercise.utils.string
 * @since R9.0
 */
public class ProvStringSplit {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ProvStringSplit.class);

    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();

        String ignoreError = "205100,104107,110109,201000,101040,202,201,205,218,204,220,206,225,1001,430101:-2410,430302:-2434|-2411,430301:-2436,430102:-2411|-2441,230102:201600|201400,230113:201200,213301:105030,212602:105010,237602:201700|802001:131502|802002:131501|992001:12339";
        String[] eventCodelist = ignoreError.split(",|;");
        ArrayList defaultCode = new ArrayList();

        for (int i = 0; i < eventCodelist.length; i++) {
            String strEvcentCode = eventCodelist[i].trim();
            if (strEvcentCode.length() <= 0) {
                continue;
            }

            String[] eventList = strEvcentCode.split(":");
            if (eventList.length == 1) {
                String errorCode = eventList[0].trim();
                if (errorCode.length() > 0) {
                    defaultCode.add(errorCode);
                }
            }
            else if (eventList.length == 2) {
                String strEvent = eventList[0].trim();
                String strErrorCode = eventList[1].trim();
                if (strEvent.length() > 0 && strErrorCode.length() > 0) {
                    List<String> arrErrorCode = new ArrayList<>();
                    String[] errorCode = strErrorCode.split("\\|");
                    for (int j = 0; j < errorCode.length; j++) {
                        if (errorCode[j].trim().length() > 0) {
                            arrErrorCode.add(errorCode[j].trim());
                        }
                    }

                    map.put(strEvent, arrErrorCode);
                }
            }
        }

        if (!defaultCode.isEmpty()) {
            map.put("_default", defaultCode);
        }

        logger.info("Parsed ignoreError Map:" + map.toString());
    }

}
