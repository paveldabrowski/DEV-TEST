package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("/* -------------------- Task1 ------------------ */");
        Task1 task1 = new Task1("assets/task1.txt");
        System.out.println("Output list: " + task1.getSortedDistinctList());
        System.out.println("Count: " + task1.getCount());
        System.out.println("Distinct: " + task1.getDistinct());
        System.out.println("Min value: " + task1.getMinValue());
        System.out.println("Max value: " + task1.getMaxValue());

        System.out.println();
        System.out.println("/* -------------------- Task2 ------------------ */");
        Task2 task2 = new Task2("assets/task2.txt");
        task2.printPairs();

        System.out.println();
        System.out.println("/* -------------------- Task3 ------------------ */");
        Task3 task3 = new Task3("assets/task3-2.txt");
        System.out.println();
        System.out.println("Graphs count: " + task3.getGraphsCount());
    }
}
