package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class Main {

    public static void main(String[] args) {


        int[] q1 = new int[] {2, 6, 2, 6, 8, 1, 6, 2, 8, 9, 1, 3, 5, 6, 0, 6, 6, 9, 9, 6};
        int [] q2 = new int[] {0, 3, 1, 0, 3, 6, 7, 3, 2, 2, 1, 5, 3, 3, 8, 2, 8, 5, 8, 0};

        slater(q1, q2);
        pareto(q1, q2);

    }



    private static void pareto(int[] q1, int[]  q2) {
        int i = 0;
        int j = 1;

        while (i < q1.length - 2) {
            if (j == q1.length - 1) {
                i++;
                j = i+1;
            }
            else if (q1[i] >= q1[j] && q2[i]>= q2[j]) {
                q1[j] = 0;
                q2[j] = 0;
                j++;
            }
            else if (q1[i] <= q1[j] && q2[i] <= q2[j]) {
                q1[i] = 0;
                q2[i] = 0;
                i++;
                j = i+1;
            }
            else {
                j++;
            }
        }


        System.out.println("Множина значень за Парето:");
        for (i = 0; i < q1.length; i++) {
            if (q1[i] != 0 && q2[i] != 0) {
                System.out.println(q1[i] + ";" + q2[i]);
            }
        }

    }

    private static void slater(int[] q1, int[]  q2) {
        int i = 0;
        int j = 1;

        while (i < q1.length - 2) {
            if (j == q1.length - 1) {
                i++;
                j = i+1;
            }
            else if (q1[i] > q1[j] && q2[i]> q2[j]) {
                q1[j] = 0;
                q2[j] = 0;
                j++;
            }
            else if (q1[i] < q1[j] && q2[i] < q2[j]) {
                q1[i] = 0;
                q2[i] = 0;
                i++;
                j = i+1;
            }
            else {
                j++;
            }
        }


        System.out.println("Множина значень за Слейтером:");
        for (i = 0; i < q1.length; i++) {
            if (q1[i] != 0 && q2[i] != 0) {
                System.out.println(q1[i] + ";" + q2[i]);
            }
        }

    }

}
