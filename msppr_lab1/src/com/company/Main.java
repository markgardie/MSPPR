package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class Main {

    public static void main(String[] args) {


        ArrayList<Integer> q1 = new ArrayList<>(Arrays.asList(2, 6, 2, 6, 8, 1, 6, 2, 8, 9, 1, 3, 5, 6, 0, 6, 6, 9, 9, 6));
        ArrayList<Integer> q2 = new ArrayList<>(Arrays.asList(0, 3, 1, 0, 3, 6, 7, 3, 2, 2, 1, 5, 3, 3, 8, 2, 8, 5, 8, 0));
        pareto(q1, q2);

    }



    private static void pareto(ArrayList<Integer> q1, ArrayList<Integer>  q2) {
        int i = 0;
        int j = 1;

        while (i < q1.size() - 1 && j < q1.size()) {
            if (q1.get(i) >= q1.get(j) && q2.get(i) >= q2.get(j)) {
                q1.remove(j);
                q2.remove(j);
                j = 1;
            }
            else if (q1.get(i)  <= q1.get(j) && q2.get(i) <= q2.get(j)) {
                q1.remove(i);
                q2.remove(i);
                i = 0;
            }
            else {
                j++;
            }
        }


        System.out.println("Множина значень за Парето:");
        for (i = 0; i < q1.size(); i++) {
            System.out.println(q1.get(i) + ":" + q2.get(i));
        }

    }
}
