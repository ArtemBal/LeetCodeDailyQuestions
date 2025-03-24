package Problems;

import java.util.Map;
import java.util.TreeMap;

public class Q3169 {
    public int countDays(int days, int[][] meetings) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] arr: meetings) {
            int start = arr[0];
            int end = arr[1];
            if(map.isEmpty()) {
                map.put(start, end);
                continue;
            }

            Map.Entry<Integer, Integer> floor = map.floorEntry(start);
            if(floor != null && floor.getValue() >= start) {
                if(floor.getValue() >= end) {
                    continue;
                }
                start = Math.min(start, floor.getKey());
            }
            Map.Entry<Integer, Integer> ceil = map.ceilingEntry(start + 1);
            while(ceil != null && ceil.getKey() <= end + 1) {
                map.remove(ceil.getKey());
                if(ceil.getValue() >= end) {
                    end = ceil.getValue();
                    break;
                }
                ceil = map.ceilingEntry(start + 1);
            }
            map.put(start, end);
            if(end == days && start == 1) {
                return 0;
            }
        }
        int ans = days;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            ans -= entry.getValue() - entry.getKey() + 1;
        }
        return ans;
    }
}
