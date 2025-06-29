package Problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class Q2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i: nums) {
            if(pq.size() < k) {
                pq.offer(i);
                continue;
            }
            if(pq.peek() < i) {
                pq.poll();
                pq.offer(i);
            }
        }
        boolean[] taken = new boolean[nums.length];
        while(!pq.isEmpty()) {

            int curr = pq.poll();
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == curr && !taken[i]) {
                    taken[i] = true;
                    break;
                }
            }

        }
        int[] ans = new int[k];
        int ansIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(taken[i]) {
                ans[ansIndex++] = nums[i];
            }
        }
        return ans;
    }
}
