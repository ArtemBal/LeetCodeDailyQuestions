package Problems;

import java.util.ArrayList;
import java.util.List;

public class Q2200 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int next = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == key) {
                int start = Math.max(i - k, next);
                int end = i + k;
                while(start < n && start <= end) {
                    if(nums[start] == key) {
                        end = start + k;
                    }
                    ans.add(start++);
                }
                next = start;
                i = start - 1;
            }
        }
        return ans;
    }
}
