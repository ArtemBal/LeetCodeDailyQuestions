package Problems;

import java.util.Arrays;

public class Q2460 {
    public int[] applyOperations(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
            if(nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        nums[index++] = nums[nums.length - 1];
        Arrays.fill(nums, index, nums.length, 0);
        return nums;
    }
}
