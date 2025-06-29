package Problems;

import java.util.Arrays;

public class Q1498 {
    public int numSubseq(int[] nums, int target) {
        final int MOD = (int) 1e9 + 7;
        int n = nums.length;
        Arrays.sort(nums);
        int[] pows = new int[n];
        pows[0] = 1;
        for(int i = 1; i < n; i++) {
            pows[i] = pows[i - 1] * 2 % MOD;
        }
        int ans = 0;
        int l = 0;
        int r = n - 1;
        while(l <= r) {
            if(nums[l] + nums[r] <= target) {
                ans = (ans + pows[r - l]) % MOD;
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
