package com.company;

import java.util.*;

import static java.util.Map.entry;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer, Integer> q1 = new HashMap<Integer, Integer>() {{
            put(1, 2);
            put(2, 6);
            put(3, 2);
            put(4, 6);
            put(5, 8);
            put(6, 1);
            put(7, 6);
            put(8, 2);
            put(9, 8);
            put(10, 9);
            put(11, 1);
            put(12, 3);
            put(13, 5);
            put(14, 6);
            put(15, 0);
            put(16, 6);
            put(17, 6);
            put(18, 9);
            put(19, 9);
            put(20, 6);
        }};

        HashMap<Integer, Integer> q2 = new HashMap<Integer, Integer>() {{
            put(1, 0);
            put(2, 3);
            put(3, 1);
            put(4, 0);
            put(5, 3);
            put(6, 6);
            put(7, 7);
            put(8, 3);
            put(9, 2);
            put(10, 2);
            put(11, 1);
            put(12, 5);
            put(13, 3);
            put(14, 3);
            put(15, 8);
            put(16, 2);
            put(17, 8);
            put(18, 5);
            put(19, 8);
            put(20, 0);
    }};

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
        Set<Integer> alternatives = q1.keySet();
        System.out.println(alternatives);

    }
}
