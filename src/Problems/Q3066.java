package Problems;

import java.util.PriorityQueue;

public class Q3066 {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(int i: nums) {
            queue.add((long)i);
        }
        int steps = 0;
        while(queue.size() >= 2 && queue.peek() < k) {
            long temp = queue.poll() * 2 + queue.poll();
            queue.add(temp);
            steps++;
        }
        return steps;
    }
}
