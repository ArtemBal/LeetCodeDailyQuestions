package Problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q1353 {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int maxDay = 0;
        for(int[] e : events) {
            maxDay = Math.max(maxDay, e[1]);
        }
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1, j = 0; i <= maxDay; i++) {
            while (j < n && events[j][0] <= i) {
                pq.offer(events[j][1]);
                j++;
            }
            while (!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }
        }
        return ans;
    }
}
