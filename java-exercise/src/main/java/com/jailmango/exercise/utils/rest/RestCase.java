package com.jailmango.exercise.utils.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * RestCase
 *
 * @author he.gang33
 * @CreateDate 2019-02-18
 * @see com.jailmango.exercise.utils.rest
 * @since R9.0
 */
public class RestCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(RestCase.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        logger.debug("start...");

        List<Long> list = new ArrayList<>();
        list.add(35L);
        list.add(36L);
        list.add(37L);

        Map<String, List<Long>> map = new HashMap<>(1);
        map.put("zoneMapIdList", list);

        String url = "";
        Object value = postForObject(url, map, String.class);

        // Object value = getForObject(url, map, Object.class);

        logger.debug("end...");
    }

    private static <T> T postForObject(String url, Object request, Class<T> responseType) {
        logger.debug("Begin to send post request to {}", url);

        RestTemplate template = new RestTemplate();
        ResponseEntity<T> responseEntity;

        // POST请求
        responseEntity = template.postForEntity(url, request, responseType);

        return responseEntity.getBody();
    }

    private static <T> T getForObject(String url, Object request, Class<T> responseType) {
        logger.debug("Begin to send post request to {}", url);

        RestTemplate template = new RestTemplate();
        ResponseEntity<T> responseEntity;

        // POST请求
        responseEntity = template.getForEntity(url, responseType, request);

        return responseEntity.getBody();
    }
}
