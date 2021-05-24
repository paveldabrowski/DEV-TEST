package com.company;

import java.util.Arrays;

public class Task2 extends AbstractTask {

    private final String[] allNumbers;

    Task2(String path) {
        allNumbers = super.getDataFromFile(path, "Task 2");
    }

    void printPairs() {
        int[] ints = convertToSortedIntegerArray();
        int arrayLength = ints.length;
        for (int i = 0; i < arrayLength; i++) {
            for (int j = i + 1; j < arrayLength; j++) {
                if (i != j && ints[i] + ints[j] == 13) {
                    System.out.println("" + ints[i] + " " + ints[j]);
                }
            }
        }
    }

    private int[] convertToSortedIntegerArray() {
        try {
            int[] ints = Arrays.stream(allNumbers).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(ints);
            return ints;
        } catch (NumberFormatException e) {
            System.err.println("Input String cannot be parsed to Integer. Task 2 input is wrong.");
            System.exit(1);
        }
        throw new RuntimeException();
    }
}
