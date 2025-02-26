package Problems;

public class Q1749 {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int maxSub = nums[0];
        int minSub = nums[0];
        for(int i = 1; i < n; i++) {
            maxSub = Math.max(maxSub + nums[i], nums[i]);
            minSub = Math.min(minSub + nums[i], nums[i]);
            max = Math.max(max, maxSub);
            min = Math.min(min, minSub);
        }
        return Math.max(Math.abs(max), Math.abs(min));
    }
}
