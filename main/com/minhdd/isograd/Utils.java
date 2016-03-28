package com.minhdd.isograd;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static double[] doubleArray(String s, int n) {
        double[] doubles = Arrays.asList(s.split(" ")).stream().mapToDouble(Double::valueOf).toArray();
        if (doubles.length == n) {
            return doubles;
        } else {
            return null;
        }
    }

    public static int[] intArray(String s) {
        return Arrays.asList(s.split(" ")).stream().mapToInt(Integer::valueOf).toArray();
}
}
