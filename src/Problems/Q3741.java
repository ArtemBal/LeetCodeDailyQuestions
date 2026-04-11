package Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3741 {
    public int minimumDistance(int[] nums) {
        Map<Integer, ArrayList<Integer>> positions = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            positions.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int min = Integer.MAX_VALUE;
        for(List<Integer> list : positions.values()) {
            int left = 0;
            int right = 2;
            while(right < list.size()) {
                min = Math.min(min, 2 * (list.get(right) - list.get(left)));
                left++;
                right++;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
