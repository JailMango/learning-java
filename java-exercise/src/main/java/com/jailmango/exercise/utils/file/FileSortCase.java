package com.jailmango.exercise.utils.file;

import cn.hutool.core.io.file.FileReader;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * FileSortCase
 *
 * @author hegang1
 * @CreateDate 2022/9/15
 * @see com.jailmango.exercise.utils.file
 */
@Slf4j
public class FileSortCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {


        // String filePath8131 = "/Users/mango/Downloads/resource-8131-35.log";
        // String filePath7925 = "/Users/mango/Downloads/resource-7925-35.log";
        // FileReader fileReader8131 = new FileReader(filePath8131);
        // FileReader fileReader7925 = new FileReader(filePath7925);
        //
        // List<String> lines = fileReader8131.readLines();
        //
        //
        // Map<String, List<String>> sortedResult = lines.stream().map(s -> {
        //     String regex = "\"code\":200,\"message\":\"success\"";
        //     return s.replaceAll("\\[http-nio-8080-exec-.*url", "url")
        //             .replaceAll(", Content-Type=application/json", "")
        //             .replaceAll("\"code\":200,\"message\":\"success\"","")
        //             .replaceAll(",\"gmtCr.*null", "")
        //             .replaceAll(", kubeflow-fullname=null, kubeflow-email=null", "");
        //     // return s;
        // }).sorted().collect(Collectors.groupingBy(o -> {
        //     if (o.contains("http://10.101.81.46:1027/resourceManager/api/resourcePool/118")) {
        //         return "118";
        //     }
        //     else if (o.contains("http://10.101.81.46:1027/resourceManager/api/resourcePool/117")) {
        //         return "117";
        //     }
        //     else if (o.contains("http://10.101.81.46:1027/resourceManager/api/resourcePool/119")) {
        //         return "119";
        //     }
        //
        //     return "empty";
        // }));
        //
        //
        // // for (String line : sortedResult.get("117")) {
        // //     System.out.println(line);
        // // }
        //
        // for (String line : sortedResult.get("118")) {
        //     System.out.println(line);
        // }
        //
        // for (String line : sortedResult.get("119")) {
        //     System.out.println(line);
        // }


        String filePath8131 = "/Users/mango/Downloads/createnb-35.log";
        FileReader fileReader7925 = new FileReader(filePath8131);

        List<String> lines = fileReader7925.readLines();


        Map<String, List<String>> sortedResult = lines.stream().map(s -> {
            String regex = "\"code\":200,\"message\":\"success\"";
            return s.replaceAll("\\[http-nio-8080-exec-.*url", "url")
                    .replaceAll(", Content-Type=application/json", "")
                    .replaceAll("\"code\":200,\"message\":\"success\"","")
                    .replaceAll(",\"gmtCr.*null", "")
                    .replaceAll(", kubeflow-fullname=null, kubeflow-email=null", "");
            // return s;
        }).sorted().collect(Collectors.groupingBy(o -> {
            if (o.contains("\"resourcePoolId\":118")) {
                return "118";
            }
            else if (o.contains("\"resourcePoolId\":117")) {
                return "117";
            }
            else if (o.contains("\"resourcePoolId\":119")) {
                return "119";
            }

            return "114";
        }));


        for (String line : sortedResult.get("114")) {
            System.out.println(line);
        }

        for (String line : sortedResult.get("118")) {
            System.out.println(line);
        }

        for (String line : sortedResult.get("119")) {
            System.out.println(line);
        }
    }
}
