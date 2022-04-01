package com.jailmango.exercise.java8.stream;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * StreamCase
 *
 * @author jailmango
 * @see com.jailmango.exercise.java8.stream
 */
@Slf4j
public class StreamCase {

    /**
     * main
     *
     * @param args
     *            String[]
     */
    public static void main(String[] args) {
        List<String> ids = new ArrayList<>();
        ids.add("2230100230100");
        ids.add("2320100320100");
        ids.add("2110100320100");
        ids.add("2310100320100");

        List<String> ids2 = new ArrayList<>();
        ids2.add("2230100230100");
        ids2.add("2320100320100");
        ids2.add("2110100320100");
        ids2.add("2310100320100");

        List<String> ids3 = new ArrayList<>();
        ids3.add("2230100230100");
        ids3.add("2320100320100");
        ids3.add("2110100320100");
        ids3.add("2310100320100");

        Route route1 = Route.builder().strategy("1").searchIds(ids).build();
        Route route2 = Route.builder().strategy("2").searchIds(ids2).build();
        Route route3 = Route.builder().strategy("3").searchIds(ids3).build();
        Route route4 = Route.builder().strategy("4").searchIds(ids).build();
        Route route5 = Route.builder().strategy("5").searchIds(ids3).build();

        List<Route> routes = new ArrayList<>();
        routes.add(route5);
        routes.add(route4);
        routes.add(route3);
        routes.add(route2);
        routes.add(route1);

        RecommendRoutes recommendRoutes = RecommendRoutes.builder().routes(routes).build();

        List<String> strategies = new ArrayList<>();
        strategies.add("1");
        strategies.add("2");

        List<Route> result = recommendRoutes.getRoutes().stream().filter(route -> Objects.nonNull(route) && StringUtils.isNotBlank(route.getStrategy())
            && CollectionUtils.isNotEmpty(route.getSearchIds()) && !strategies.contains(route.getStrategy())).collect(Collectors.toList());

        List<String> strings = recommendRoutes
            .getRoutes().stream().filter(route -> Objects.nonNull(route) && StringUtils.isNotBlank(route.getStrategy())
                && CollectionUtils.isNotEmpty(route.getSearchIds()) && !strategies.contains(route.getStrategy()))
            .flatMap(route -> route.getSearchIds().stream()).collect(Collectors.toList());

        log.info("{}", strings);

        log.info("contains empty: {}", !strategies.contains(""));
        log.info("contains null: {}", !strategies.contains(null));
        log.info("contains empty: {}", !new ArrayList<>().contains(""));
        log.info("contains null: {}", !new ArrayList<>().contains(null));

        List<String> removeList = new ArrayList<>();
        removeList.add("1");
        removeList.add("2");

        strategies.removeAll(removeList);

        log.info("end");
    }

    @Builder
    @Data
    private static class RecommendRoutes {

        private List<Route> routes;
    }

    @Builder
    @Data
    private static class Route {

        private String strategy;

        private List<String> searchIds;
    }
}
