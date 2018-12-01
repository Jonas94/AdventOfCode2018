package aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {

    public static void main(String[] args) {

        int resultingFrequency = 0;
        int currentFrequency = 0;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("resources/inputDay1.txt"));
            String line = reader.readLine();
            while (line != null) {
                currentFrequency = Integer.parseInt(line);
                resultingFrequency += currentFrequency;
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Resulting frequency: " + resultingFrequency);
    }
}
