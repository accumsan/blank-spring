package com.minhdd;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class TrendingTopics {
    private static final String NOT_FOUND = "NOT_FOUND";
    private static final int WINDOW = 60;
    private static final int THRESHOLD = 40;

    private String trending(List<String> topics, int i, Map<String, Integer> previousTopicCount) {
        if (topics.size() < THRESHOLD) return NOT_FOUND;
        if (i >= topics.size() - WINDOW) return NOT_FOUND;
        Map<String, Integer> topicsCount;
        if (i == 0) {
            topicsCount = new HashMap<>();
            Map<String, List<String>> topicsGrouped = topics.stream().limit(WINDOW).collect(groupingBy(it -> it));
            topicsGrouped.keySet().stream().forEach(topic -> topicsCount.put(topic, topicsGrouped.get(topic).size()));
        } else {
            topicsCount = update(previousTopicCount, topics.get(i - 1), topics.get(i - 1 + WINDOW));
        }
        return topicsCount.keySet().stream()
                .filter(key -> topicsCount.get(key) >= THRESHOLD)
                .findFirst().orElse(trending(topics, i + 1, topicsCount));
    }

    private Map<String, Integer> update(Map<String, Integer> previousTopicCount, String oldTopic, String newTopic) {
        if (oldTopic.equals(newTopic)) {
            return previousTopicCount;
        }
        Map<String, Integer> topicsCount = new HashMap<>(previousTopicCount);
        topicsCount.put(oldTopic, topicsCount.get(oldTopic) - 1);
        Integer newTopicCount = topicsCount.containsKey(newTopic) ? topicsCount.get(newTopic) + 1 : 1;
        topicsCount.put(newTopic, newTopicCount);
        return topicsCount;
    }

    @Test
    public void should_not_found_when_count_inferior_than_threshold_trending() throws IOException {
        List<String> trendingStream39 = Files.lines(Paths.get("data/input1.txt")).skip(1).limit(THRESHOLD-1).collect(toList());
        assertEquals("NOT_FOUND", trending(trendingStream39, 0, null));
    }

    @Test
    public void when_count_between_threshold_and_window() throws IOException {
        List<String> trendingStream60 = Files.lines(Paths.get("data/input1.txt")).skip(1).limit(WINDOW).collect(toList());
        assertEquals("NOT_FOUND", trending(trendingStream60, 0, null));
    }

    @Test
    public void when_example1() throws IOException {
        test("data/input1.txt", "#economie");
    }

    @Test
    public void when_example2() throws IOException {
        test("data/input2.txt", "#politique");
    }

    private void test(String inputPath, String output) throws IOException {
        List<String> trendingStreamExample1 = Files.lines(Paths.get(inputPath)).skip(1).collect(toList());
        assertEquals(output, trending(trendingStreamExample1, 0, null));
    }
}
