package Problems;

import java.util.PriorityQueue;

public class Q3264 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for(int i = 0; i < nums.length; i++) {
            pq.offer(new int[] {nums[i], i});
        }
        while(k-- > 0) {
            int[] arr = pq.poll();
            arr[0] *= multiplier;
            nums[arr[1]] = arr[0];
            pq.offer(arr);
        }
        return nums;
    }
}
