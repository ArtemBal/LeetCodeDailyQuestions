package Problems;

import java.util.List;

public class Q3349 {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        outer: for(int i = 0; i <= nums.size() - k * 2; i++) {
            for(int j = i; j < i + k - 1; j++) {
                if(nums.get(j) >= nums.get(j + 1)) {
                    i = j;
                    continue outer;
                }
            }
            for(int j = i + k; j < i + k * 2 - 1; j++) {
                if(nums.get(j) >= nums.get(j + 1)) {
                    continue outer;
                }
            }
            return true;
        }
        return false;
    }
}
