package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class AbstractTask {

    String[] getDataFromFile( String path, String taskName ){
        try ( BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path))) ) {
            return reader.readLine().split(" ");
        } catch (IOException e) {
            System.err.println("File not found. Provide correct path to input file in " + taskName + ".");
            System.exit(1);
        } catch (NullPointerException e2) {
            System.err.println("File is empty. Provide file with proper data to " + taskName + ".");
            System.exit(1);
        }
        throw new RuntimeException("");
    }
}
