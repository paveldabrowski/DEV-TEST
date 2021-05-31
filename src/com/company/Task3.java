package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;

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
                String[] pair = reader.readLine().split(" ");
                inputPairs.add(Arrays.stream(pair).mapToInt(Integer::parseInt).toArray());
            }
            inputPairs.sort(Comparator.comparingInt(o -> o[0]));
//            printInputPairs(inputPairs);
        } catch (IOException e) {
            System.err.println("File not found. Provide correct path to input file in " + TASK_NAME + ".");
            System.exit(1);
        } catch (NullPointerException e2) {
            System.err.println("Provide file with proper data to " + TASK_NAME + ".");
            System.exit(1);
        } catch (NumberFormatException e3) {
            System.err.println("Input String cannot be parsed to Integer. " + TASK_NAME + " input is wrong.");
            System.exit(1);
        }
    }

    private void printInputPairs(List<int[]> inputPairs) {
        inputPairs.forEach(pair -> System.out.println(Arrays.toString(pair)));
    }

    int getGraphsCount() {
        List<Set<int[]>> graphs = new ArrayList<>();
        int inputPairsSize = inputPairs.size();
        for (int i = 0; i < inputPairsSize; i++) {
            int[] newPair = inputPairs.get(i);
            if (graphs.stream().anyMatch(graph -> graph.contains(newPair)))
                continue;

            Set<int[]> graph = new HashSet<>(List.of(newPair));
            int j = i + 1;
            while (j < inputPairsSize) {
                int[] nextPair = inputPairs.get(j);
                addConnectedPairsToFirstPair(graph, nextPair);
                j++;
            }
            checkConnectionBetweenPreviousGraphs(graph, graphs);
        }
        return graphs.size();
    }

    private void addConnectedPairsToFirstPair(Set<int[]> graph, int[] nextPair) {
        Predicate<int[]> predicate = pair -> !graph.contains(nextPair) && (
                        pair[1] == nextPair[0] ||
                        pair[0] == nextPair[1] ||
                        pair[0] == nextPair[0] ||
                        pair[1] == nextPair[1]
        );
        boolean edgeMatchesToGraph = graph.stream().anyMatch(predicate);
        if (edgeMatchesToGraph)
            graph.add(nextPair);
    }

    private void checkConnectionBetweenPreviousGraphs(Set<int[]> graph, List<Set<int[]>> graphs) {
        Optional<Set<int[]>> connectedGraph = graphs.stream()
                .filter(previousGraph -> graph.stream().anyMatch(previousGraph::contains))
                .findFirst();
        if (connectedGraph.isPresent())
            connectedGraph.get().addAll(graph);
        else
            graphs.add(graph);
    }
}
