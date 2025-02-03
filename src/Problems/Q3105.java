package Problems;

public class Q3105 {
    public int longestMonotonicSubarray(int[] nums) {
        int decr = 1;
        int incr = 1;
        int longest = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] < nums[i]) {
                incr++;
                decr = 1;
            } else if(nums[i - 1] > nums[i]) {
                decr++;
                incr = 1;
            } else {
                decr = 1;
                incr = 1;
            }
            longest = Math.max(longest, Math.max(decr, incr));
        }
        return longest;
    }
}
