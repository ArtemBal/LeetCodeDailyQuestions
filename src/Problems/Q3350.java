package Problems;

import java.util.List;

public class Q3350 {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] incr = new int[n];
        incr[0] = 1;
        for(int i = 1; i < n; i++) {
            if(nums.get(i) > nums.get(i - 1)) {
                incr[i] = incr[i - 1] + 1;
            } else {
                incr[i] = 1;
            }
        }
        int max = 0;
        int prev = incr[n - 1];
        if(prev == n) {
            return n / 2;
        }
        for(int i = n - 1 - prev; i >= 0; i -= prev) {
            int curr = incr[i];
            max = Math.max(max, Math.max(Math.max(prev, curr) / 2, Math.min(prev, curr)));
            prev = curr;
        }
        return max;
    }
}
