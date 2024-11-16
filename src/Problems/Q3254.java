package Problems;

public class Q3254 {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        if(n == 1 || k == 1) {
            return nums;
        }
        int[] ans = new int[n - k + 1];
        int count = 1;
        for(int i = 1; i < n; i++) {
            if(nums[i - 1] + 1 == nums[i]) {
                count++;
            } else {
                count = 1;
            }
            if(i >= k - 1 && count >= k) {
                ans[i - k + 1] = nums[i];
            } else if(i >= k - 1) {
                ans[i - k + 1] = -1;
            }
        }
        return ans;
    }
}
