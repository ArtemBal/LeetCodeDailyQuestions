package Problems;

import java.util.Arrays;

public class Q2616 {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = nums[n - 1] - nums[0] + 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (countPairsWithDifference(nums, mid) >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int countPairsWithDifference(int[] nums, int maxDifference) {
        int pairCount = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i + 1] - nums[i] <= maxDifference) {
                pairCount++;
                i++;
            }
        }
        return pairCount;
    }
}
