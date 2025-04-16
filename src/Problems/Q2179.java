package Problems;

import java.util.HashMap;
import java.util.Map;

public class Q2179 {
    public long countGood(int[] nums, int k) {
        int l = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        long count = 0;
        int pair = 0;
        for(int i = 0; i < nums.length; i++) {
            int temp = countMap.merge(nums[i], 1, Integer::sum);
            pair += temp - 1;
            while(pair >= k && l < i) {
                count += nums.length - i;
                temp = countMap.merge(nums[l], -1, Integer::sum);
                pair -= temp;
                if(temp == 0) {
                    countMap.remove(nums[l]);
                }
                l++;
            }
        }
        return count;
    }
}
