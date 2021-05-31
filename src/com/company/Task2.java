package com.company;

import java.util.Arrays;

public class Task2 extends AbstractTask {

    private final String[] allNumbers;

    Task2(String path) {
        allNumbers = super.getDataFromFile(path, "Task 2");
    }

    void printPairs() {
        int[] ints = convertToSortedIntegerArray();
        int left = 0;
        int right = ints.length - 1;
        while(left < right) {
            int sum = ints[left] + ints[right];
            if (sum == 13) {
                System.out.printf("(%d, %d)", ints[left], ints[right]);
                System.out.println();
                left = left + 1;
                right = right - 1;
            } else if (sum < 13) {
                left = left + 1;
            } else {
                right = right - 1;
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
