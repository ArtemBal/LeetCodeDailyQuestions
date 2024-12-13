package Problems;

import java.util.PriorityQueue;

public class Q2593 {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] check = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for(int i = 0; i < n; i++) {
            pq.offer(new int[] {nums[i], i});
        }
        long total = 0;

        int[] changes = new int[] {1, -1};
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            total += curr[0];
            check[curr[1]] = true;
            for(int i: changes) {
                if(curr[1] + i >= 0 && curr[1] + i < n) {
                    check[curr[1] + i] = true;
                }
            }

            while(!pq.isEmpty() && check[pq.peek()[1]]) {
                pq.poll();
            }
        }
        return total;
    }
}
