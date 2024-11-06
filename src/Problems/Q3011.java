package Problems;

public class Q3011 {
    public boolean canSortArray(int[] nums) {
        int prevMax = Integer.MIN_VALUE;
        int n = nums.length;
        int i = 0;
        while(i < n) {
            int j = i + 1;
            int bitCount = Integer.bitCount(nums[i]);
            int min = nums[i], max = nums[i];
            while (j < n && Integer.bitCount(nums[j]) == bitCount) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                j++;
            }
            if (prevMax > min) {
                return false;
            }
            i = j;
            prevMax = max;
        }
        return true;
    }
}
