package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2966 {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        List<int[]> ans = new ArrayList<>(n / 3);
        Arrays.sort(nums);
        for(int i = 0; i < n; i += 3) {
            if(k < nums[i + 2] - nums[i]) {
                return new int[0][];
            }
            ans.add(new int[] {nums[i], nums[i + 1], nums[i + 2]});
        }
        return ans.toArray(new int[0][]);
    }
}
