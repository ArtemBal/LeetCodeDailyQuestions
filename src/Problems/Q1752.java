package Problems;

public class Q1752 {
    public boolean check(int[] nums) {
        int n = nums.length;
        int decrCount = 0;
        for(int i = 1; i < n; i++) {
            if(nums[i - 1] > nums[i]) {
                decrCount++;
            }
        }
        if(nums[n - 1] > nums[0]) {
            decrCount++;
        }
        return decrCount <= 1;
    }
}
