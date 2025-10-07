package Problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Q1488 {
    public int[] avoidFlood(int[] rains) {
        TreeSet<Integer> sunnyDays = new TreeSet<>();
        Map<Integer, Integer> lastRainDay = new HashMap<>();
        int[] ans = new int[rains.length];
        for(int i = 0; i < rains.length; i++) {
            if(rains[i] == 0) {
                sunnyDays.add(i);
                ans[i] = 1;
            } else {
                ans[i] = -1;
                if(!lastRainDay.containsKey(rains[i])) {
                    lastRainDay.put(rains[i], i);
                } else {
                    int lastDay = lastRainDay.get(rains[i]);
                    Integer nextSunnyDay = sunnyDays.higher(lastDay);
                    if(nextSunnyDay == null) {
                        return new int[0];
                    } else {
                        ans[nextSunnyDay] = rains[i];
                        sunnyDays.remove(nextSunnyDay);
                        lastRainDay.put(rains[i], i);
                    }
                }
            }
        }
        return ans;
    }
}
