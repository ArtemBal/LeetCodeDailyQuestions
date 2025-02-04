package Problems;

public class Q1800 {
    public int maxAscendingSum(int[] nums) {
        int max = 0;
        int curr = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                curr += nums[i];
            } else {
                max = Math.max(curr, max);
                curr = nums[i];
            }
        }
        return Math.max(curr, max);
    }
}
