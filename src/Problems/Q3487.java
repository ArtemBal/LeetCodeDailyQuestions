package Problems;

import java.util.HashSet;

public class Q3487 {
    public int maxSum(int[] nums) {
        var set = new HashSet<Integer>();
        int sum = 0;
        int minNegative = Integer.MIN_VALUE;
        for(int n : nums) {
            if(n > 0) {
                if(set.add(n)) {
                    sum += n;
                }

            } else {
                minNegative = Math.max(minNegative, n);
            }
        }
        return sum == 0 ? minNegative : sum;
    }
}
