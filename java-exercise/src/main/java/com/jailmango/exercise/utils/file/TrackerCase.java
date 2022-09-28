package com.jailmango.exercise.utils.file;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileWriter;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TrackerCase
 *
 * @author hegang1
 * @CreateDate 2022/8/20
 * @see com.jailmango.exercise.utils.file
 */
@Slf4j
public class TrackerCase {

    private static final String PATH = "/Users/mango/Documents/repository/learning/trackerslist/";

    private static final List<String> files = Lists.newArrayList(
            "trackers_all_https.txt"
            , "trackers_all_ws.txt"
            , "trackers_all.txt"
            , "trackers_all_ip.txt"
            , "trackers_best.txt"
            , "trackers_all_http.txt"
            , "trackers_all_udp.txt"
            , "trackers_best_ip.txt"
    );

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        List<String> lines = Lists.newArrayList();

        for (String file : files) {
            FileUtil.readLines(new File(PATH + file), StandardCharsets.UTF_8, lines);
        }

        List<String> result = lines.stream()
                .filter(StringUtils::isNotBlank)
                .distinct()
                .collect(Collectors.toList());

        FileWriter writer = FileWriter.create(new File(PATH + "result.txt"), StandardCharsets.UTF_8);

        for (String line : result) {
            writer.write(line + System.lineSeparator(), true);
            writer.write(System.lineSeparator(), true);
        }

        // writer.writeLines(result);
    }
}
