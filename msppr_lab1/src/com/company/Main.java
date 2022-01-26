package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class Main {

    public static void main(String[] args) {

        Map<Integer, Integer> q1 = Map.ofEntries(
                entry(1, 2),
                entry(2, 6),
                entry(3, 2),
                entry(4, 6),
                entry(5, 8),
                entry(6, 1),
                entry(7, 6),
                entry(8, 2),
                entry(9, 8),
                entry(10, 9),
                entry(11, 1),
                entry(12, 3),
                entry(13, 5),
                entry(14, 6),
                entry(15, 0),
                entry(16, 6),
                entry(17, 6),
                entry(18, 9),
                entry(19, 9),
                entry(20, 6)
        );

        Map<Integer, Integer> q2 = Map.ofEntries(
                entry(1, 0),
                entry(2, 3),
                entry(3, 1),
                entry(4, 0),
                entry(5, 3),
                entry(6, 6),
                entry(7, 7),
                entry(8, 3),
                entry(9, 2),
                entry(10, 2),
                entry(11, 1),
                entry(12, 5),
                entry(13, 3),
                entry(14, 3),
                entry(15, 8),
                entry(16, 2),
                entry(17, 8),
                entry(18, 5),
                entry(19, 8),
                entry(20, 0)
        );


        pareto(q1, q2);

    }

    private static void pareto(Map<Integer, Integer> q1, Map<Integer, Integer> q2) {
        int i = 1;
        int j = 2;

        while (i < q1.size() - 1 && j < q1.size()) {
            if (q1.get(i) >= q1.get(j) && q2.get(i) >= q2.get(j)) {
                q1.remove(j);
                q2.remove(j);
                j++;
            } else if (q1.get(i) <= q1.get(j) && q2.get(i) <= q2.get(j)) {
                q1.remove(i);
                q2.remove(i);
                i++;
                j = i + 1;
            } else {
                j++;
            }
        }

        System.out.println("Множина значень за Парето:");
        for (i = 0; i < q1.size(); i++) {
            System.out.println(q1.get(i) + ":" + q2.get(i));
        }

    }
}
