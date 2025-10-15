package Problems;

import java.util.List;

public class Q3350 {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int max = 0;
        int prev = 0;
        int curr = 1;
        for(int i = 1; i < n; i++) {
            if(nums.get(i) > nums.get(i - 1)) {
                curr++;
            } else {
                max = Math.max(max, Math.max(Math.max(prev, curr) / 2, Math.min(prev, curr)));
                prev = curr;
                curr = 1;
            }
        }
        max = Math.max(max, Math.max(Math.max(prev, curr) / 2, Math.min(prev, curr)));
        return max;
    }
}
