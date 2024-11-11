package Problems;

public class Q1829 {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xorSum = 0;
        for(int i: nums) {
            xorSum ^= i;
        }
        int mask = (1 << maximumBit) - 1;
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            int maxXor = xorSum ^ mask;
            ans[i] = maxXor;
            xorSum ^= nums[n - i - 1];
        }
        return ans;
    }
}
