package aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day3 {
//NOT DONE

    public static void main(String[] args) {

        List<String> rows = readFileIntoList();

        for(String s: rows) {
            String[] token = s.split("#| @ |,|: |x");
            Claim c = new Claim(Integer.parseInt(token[2]), Integer.parseInt(token[3]), Integer.parseInt(token[4]), Integer.parseInt(token[5]));
            System.out.println(c.toString());
        }
}
    private static List<String> readFileIntoList() {

        List<String> rows = new ArrayList<String>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("resources/inputDay3.txt"));
            String line = reader.readLine();
            while (line != null && line.length() > 1) {
                rows.add(line);
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return rows;
    }
}