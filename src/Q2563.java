public class Q2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] >= lower && nums[i] + nums[j] <= upper) {
                    count++;
                }
            }
        }
        return count;
    }
}
