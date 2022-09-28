package com.jailmango.exercise.utils.string;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ModifyCase
 *
 * @author hegang1
 * @CreateDate 2022/9/26
 * @see com.jailmango.exercise.utils.string
 */
@Slf4j
public class ModifyCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        String home = "/home/haha";

        List<String> list = Lists.newArrayList();
        // list.add("/home/haha/1");
        list.add("/data/2");
        list.add("/data/1");
        // list.add("/datab");
        // list.add("/data/1");
        // list.add("/data/2");

        boolean result = isValidMountPath(home, list);

        log.info("result:{}, list:{}", result, list);
    }

    private static boolean isValidMountPath(String nasWorkspace, List<String> nasDatavols) {
        String workspaceMountPath = nasWorkspace.endsWith("/") ? nasWorkspace : nasWorkspace.concat("/");
        List<String> dataVolsMountPaths = Optional.ofNullable(nasDatavols).orElse(Lists.newArrayList()).stream()
                .filter(o -> Objects.nonNull(o) && StringUtils.isNotBlank(o))
                .map(o -> o.endsWith("/") ? o : o.concat("/"))
                .collect(Collectors.toList());

        if (CollectionUtils.isEmpty(dataVolsMountPaths)) {
            return true;
        }

        for (int outer = 0; outer < dataVolsMountPaths.size(); outer++) {
            if (dataVolsMountPaths.get(outer).startsWith(workspaceMountPath)) {
                log.info("storage equals data");
                return false;
            }

            for (int inner = outer + 1; inner < dataVolsMountPaths.size(); inner++) {
                if (dataVolsMountPaths.get(outer).startsWith(dataVolsMountPaths.get(inner))
                        || dataVolsMountPaths.get(inner).startsWith(dataVolsMountPaths.get(outer))) {
                    log.info("{} equals {}", dataVolsMountPaths.get(outer), dataVolsMountPaths.get(inner));
                    return false;
                }
            }
        }

        return true;
    }
}
