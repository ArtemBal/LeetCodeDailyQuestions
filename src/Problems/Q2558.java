package Problems;

import java.util.PriorityQueue;

public class Q2558 {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long sum = 0;
        for(int i: gifts) {
            pq.add(i);
            sum += i;
        }
        while(k-- > 0) {
            int temp = pq.poll();
            int newValue = (int) Math.floor(Math.sqrt(temp));
            sum -= temp - newValue;
            pq.add(newValue);
        }
        return sum;
    }
}
