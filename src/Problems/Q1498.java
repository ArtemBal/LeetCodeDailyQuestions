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
        for (int i = 0; i < n; ++i) {
            if (nums[i] * 2L > target) {
                break;
            }
            int j = binarySearch(nums, target - nums[i], i + 1) - 1;
            ans = (ans + pows[j - i]) % MOD;
        }
        return ans;
    }

    private int binarySearch(int[] nums, int x, int left) {
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) >> 1;

            if (nums[mid] > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


}
