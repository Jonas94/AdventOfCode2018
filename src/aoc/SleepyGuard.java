package aoc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SleepyGuard {

    private int id;
    Map<Integer, Integer> minuteMap = new HashMap<Integer, Integer>();


    public void addSleepingMinutes(int[] minutes) {

        for (int minute : minutes) {
            minuteMap.merge(minute, 1, Integer::sum);

        }
    }

    public Map getSleepingMinutes() {
        return minuteMap;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getTotalSleepingMinutes() {
        int minuteCount = 0;
        for (int minute : minuteMap.keySet()) {
         //   System.out.println(minute + "  " + minuteMap.get(minute));
            minuteCount += minuteMap.get(minute);
        }

        return minuteCount;
    }


    public TreeMap getMostSleptMinute(){
        int minuteMostSlept = 0;
        int minuteMostSleptCount = 0;
        TreeMap<Integer, Integer> mostSleptMinute = new TreeMap<>();

        for (int keyMinute : minuteMap.keySet()) {
            if (minuteMap.get(keyMinute) > minuteMostSleptCount) {
                minuteMostSlept = keyMinute;
                minuteMostSleptCount = minuteMap.get(keyMinute);

            }
        }
        mostSleptMinute.put(minuteMostSlept, minuteMostSleptCount);
        return mostSleptMinute;
    }



}
