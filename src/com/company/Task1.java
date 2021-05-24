package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

class Task1 extends AbstractTask {

    private final String[] allNumbers;
    private List<Integer> distinctSortedNumbers;

    Task1(String path) {
        allNumbers = super.getDataFromFile(path, "Task 1");
    }

    List<Integer> getSortedDistinctList() {
        HashSet<String> distinctNumbers = new HashSet<>(Arrays.asList(allNumbers));
        try {
            distinctSortedNumbers = distinctNumbers.stream().map(Integer::parseInt).sorted().collect(Collectors.toList());
        } catch (NumberFormatException e) {
            System.err.println("Input String cannot be parsed to Integer. Task 1 input is wrong.");
            System.exit(1);
        }
        return distinctSortedNumbers;
    }

    int getCount() {
        return allNumbers.length;
    }

    int getDistinct() {
        return distinctSortedNumbers.size();
    }

    int getMinValue() {
        return Collections.min(distinctSortedNumbers);
    }

    int getMaxValue() {
        return Collections.max(distinctSortedNumbers);
    }
}
