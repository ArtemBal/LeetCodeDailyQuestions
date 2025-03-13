package Problems;

public class Q3356 {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for(int i = 0; i < queries.length; i++) {
            boolean flag = true;
            int curr = 0;
            for(int j = 0; j < n; j++) {
                curr += diff[j];
                if(nums[j] + curr > 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                return i;
            }

            diff[queries[i][0]] -= queries[i][2];
            diff[queries[i][1] + 1] += queries[i][2];
        }
        int curr = 0;
        for(int j = 0; j < n; j++) {
            curr += diff[j];
            if(nums[j] + curr > 0) {
                return -1;
            }
        }
        return queries.length;
    }
}
