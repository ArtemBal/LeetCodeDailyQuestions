package Problems;

import java.util.HashSet;

public class Q1695 {
    public int maximumUniqueSubarray(int[] nums) {
        var subSet = new HashSet<Integer>();
        int subSum = 0;
        int maxScore = 0;
        for(int l = 0, r = 0; r < nums.length; r++) {
            int curr = nums[r];
            if(subSet.add(curr)) {
                subSum += curr;
                maxScore = Math.max(subSum, maxScore);
            } else {
                while(l < r) {
                    int temp = nums[l];
                    l++;
                    if(temp == curr) {
                        break;
                    } else {
                        subSet.remove(temp);
                        subSum -= temp;
                    }
                }
            }
        }
        return maxScore;
    }
}
