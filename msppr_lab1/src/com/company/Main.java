package com.company;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        String first = "20,63,21,60,83,16,67,23,82,92,11,35,53,63,08,62,68,95,98,60";
        String second = "68,76,09,73,03,87,54,73,57,81,23,29,96,44,42,80,12,09,55,47";
        String third = "54,66,34,59,81,42,73,01,38,71,13,58,99,22,84,55,61,90,80,71";

        String[] arr = new String[] {
                first,
                second,
                third,
                String.join(",", first, second, third)};

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Pareto " + (i+1) + " " + driver(arr[i], pareto) + "\n" +
                    "Slater " + (i+1) + " " + driver(arr[i], pareto) + "\n");
        }

    }

    public static List<List<Integer>> parse(String row) {

        return Arrays.stream(row.split(","))
                .map(i -> Arrays.stream(i.split(""))
                        .map(Integer::parseInt)
                .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private static BiFunction<List<Integer>, List<Integer>, Boolean> pareto =
            (e1, e2) -> (e1.get(0) >= e2.get(0) && e1.get(1) > e2.get(1)) || (e1.get(0) > e2.get(0) && e1.get(1) >= e2.get(1));

    private static BiFunction<List<Integer>, List<Integer>, Boolean> salter =
            (e1, e2) -> e1.get(0) > e2.get(0) && e1.get(1) > e2.get(1);


    public static List<List<Integer>> driver(String input, BiFunction<List<Integer>, List<Integer>, Boolean> fun) {
        List<List<Integer>> parsed = parse(input);

        for(List<Integer> e1 : parsed) {
            parsed = parsed
                    .stream()
                    .filter(e2 -> fun.apply(e1, e2))
                    .collect(Collectors.toList());
        }

        return parsed;

    }
}
