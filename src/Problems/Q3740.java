package Problems;

public class Q3740 {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] == nums[j]) {
                    int k = j + 1;
                    while(k < n && nums[k] != nums[i]) {
                        k++;
                    }
                    if(k < n) {
                        ans = Math.min(ans, 2 * (k - i));
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
