package Problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q2402 {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<Integer> free = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            free.offer(i);
        }
        int[] count = new int[n];
        // {room number, end time}
        var used = new PriorityQueue<long[]>((a, b) -> a[1] != b[1] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));
        for(int[] curr: meetings) {
            int start = curr[0];
            long end = curr[1];
            while(!used.isEmpty() && used.peek()[1] <= start) {
                free.offer((int)used.poll()[0]);
            }
            int temp = 0;
            if(!free.isEmpty()) {
                temp = free.poll();
            } else {
                long[] room = used.poll();
                temp = (int) room[0];
                end = room[1] + end - start;
            }
            used.offer(new long[]{temp, end});
            count[temp]++;
        }
        //System.out.println(Arrays.deepToString(meetings));
        //System.out.println(Arrays.toString(count));
        int max = 0;
        int index = 0;
        for(int i = 0; i < n; i++) {
            if(count[i] > max) {
                index = i;
                max = count[i];
            }
        }
        return index;
    }
}
