package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class Main {

    public static void main(String[] args) {

        String first = "20,63,21,60,83,16,67,23,82,92,11,35,53,63,08,62,68,95,98,60";
        String second = "68,76,09,73,03,87,54,73,57,81,23,29,96,44,42,80,12,09,55,47";
        String third = "54,66,34,59,81,42,73,01,38,71,13,58,99,22,84,55,61,90,80,71";

        String[] array = new String[] {
                first,
                second,
                third,
                String.join(",", first, second, third)};
    }



}
