package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Task3 extends AbstractTask {

    private final String TASK_NAME = "Task 3";
    private final List<int[]> inputPairs = new ArrayList<>();

    public Task3(String path) {
        getDataFromFile(path);
    }

    private void getDataFromFile(String path) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            int numberOfLines = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numberOfLines; i++) {
                String[] strings = reader.readLine().split(" ");
                inputPairs.add(Arrays.stream(strings).mapToInt(Integer::parseInt).toArray());
            }
            Comparator<int[]> comparator = Comparator.comparingInt(o -> o[0]);
            inputPairs.sort(comparator);
            printInputPairs(inputPairs);
        } catch (IOException e) {
            System.err.println("File not found. Provide correct path to input file in " + TASK_NAME + ".");
            System.exit(1);
        } catch (NullPointerException e2) {
            System.err.println("Provide file with proper data to " + TASK_NAME + ".");
            System.exit(1);
        } catch (NumberFormatException e3) {
            System.err.println("Input String cannot be parsed to Integer.Task 3 input is wrong.");
            System.exit(1);
        }
    }

    private void printInputPairs(List<int[]> inputPairs) {
        inputPairs.forEach(ints -> System.out.println(Arrays.toString(ints)));
    }

    int getGraphsCount() {
        List<List<int[]>> graphs = new ArrayList<>();
        int size = inputPairs.size();
        for (int i = 0; i < size; i++) {
            List<int[]> pairs = new ArrayList<>();
            int[] pair = inputPairs.get(i);
            pairs.add(pair);
            int j = i + 1;

            while (j < size){
                int[] secondPair = inputPairs.get(j);
                int[] lastPair = pairs.get(pairs.size() - 1);
                if (lastPair[1] == secondPair[0] || lastPair[0] == secondPair[0]) {
                    pairs.add(secondPair);
                    j++;
                    i++;
                } else
                    break;
            }
            graphs.add(pairs);
        }
        return graphs.size();
    }
}
