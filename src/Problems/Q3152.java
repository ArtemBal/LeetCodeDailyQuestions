package Problems;

import java.util.Map;
import java.util.TreeMap;

public class Q3152 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < nums.length - 1; i++) {
            if((nums[i] & 1) != (nums[i + 1] & 1)) {
                int start = i;
                map.put(i, i);
                while(i < nums.length - 1 && (nums[i] & 1) != (nums[i + 1] & 1)) {
                    map.merge(start, 1, Integer::sum);
                    i++;
                }
            }
        }
        boolean[] ans = new boolean[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if(start == end) {
                ans[i] = true;
                continue;
            }
            if(map.containsKey(start)) {
                ans[i] = map.get(start) >= end;
            } else {
                Map.Entry<Integer, Integer> entry = map.lowerEntry(start);
                if(entry == null) {
                    ans[i] = false;
                } else {
                    ans[i] = start >= entry.getKey() && end <= entry.getValue();
                }
            }
        }
        return ans;
    }
}
