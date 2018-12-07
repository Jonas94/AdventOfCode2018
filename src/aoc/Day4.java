package aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {
//Not done
    public static void main(String[] args) {
        List<String> rows = readFileIntoList();
        Map<Integer, Integer> sleepMinutes = new TreeMap<Integer, Integer>();

        rows.sort(Comparator.naturalOrder());
        int minutesAsleep;
        int id = 0;
        for (int i = 0; i < rows.size(); i++) {
            Pattern patternID = Pattern.compile("#\\d+");
            Matcher matcherID = patternID.matcher(rows.get(i));

            if (matcherID.find()) {
                id = Integer.parseInt(matcherID.group(0).substring(1));
               //   System.out.println("ID: " + id);
                minutesAsleep = 0;
                //   System.out.println(minutesAsleep);

            }

            if (rows.get(i).contains("falls asleep")) {
                //    System.out.println(rows.get(i).substring(15, 17));

                minutesAsleep = Integer.parseInt(rows.get(i + 1).substring(15, 17)) - Integer.parseInt(rows.get(i).substring(15, 17));
                System.out.println(minutesAsleep);
                sleepMinutes.merge(id, minutesAsleep, Integer::sum);
            }

            System.out.println(rows.get(i));
        }

        int highestSleepMinutes = 0;
        int idHighestSleepMinutes = 0;
        for (int key : sleepMinutes.keySet()) {
            System.out.println(key + " " + sleepMinutes.get(key));
            if(sleepMinutes.get(key) > highestSleepMinutes){
                highestSleepMinutes = sleepMinutes.get(key);
                idHighestSleepMinutes = key;
            }
        }
        System.out.println("GUARD ID: " + idHighestSleepMinutes);
        System.out.println("Minutes asleep: " + highestSleepMinutes);
        System.out.println("Result part 1: " + idHighestSleepMinutes * highestSleepMinutes);



        //calculate most sleeped minute...





    }



    private static List<String> readFileIntoList() {
        List<String> rows = new ArrayList<String>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("resources/inputDay4.txt"));
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
