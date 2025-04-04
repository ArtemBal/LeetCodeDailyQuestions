package Problems;

public class Q2874 {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long max = 0;
        long temp = 0;
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                if(nums[i] > nums[j]) {
                    temp = nums[i] - nums[j];
                } else {
                    continue;
                }
                for(int k = j + 1; k < n; k++) {

                    long curr = temp * nums[k];
                    if(curr > max) {
                        max = curr;
                    }
                }
            }
        }
        return max <= 0 ? 0 : max;
    }

}
