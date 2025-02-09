package Problems;

import java.util.HashMap;
import java.util.Map;

public class Q2364 {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i] - i;
            ans += i - map.getOrDefault(curr, 0);
            map.merge(curr, 1, Integer::sum);
        }
        return ans;
    }
}
