package Problems;

import java.util.PriorityQueue;

public class Q1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        //PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> {
            double improvementA = (a[0] + 1) / (a[1] + 1) - a[0] / a[1];
            double improvementB = (b[0] + 1) / (b[1] + 1) - b[0] / b[1];
            return Double.compare(improvementB, improvementA);
        });

        double sum = 0;
        for(int[] arr: classes) {
            if(arr[0] == arr[1]) {
                sum += 1;
            } else {
                pq.offer(new double[] {arr[0], arr[1]});
            }
        }
        while(extraStudents-- > 0 && !pq.isEmpty()) {
            double[] currentClass = pq.poll();
            double passes = currentClass[0] + 1, totalStudents = currentClass[1] + 1;
            pq.offer(new double[] {passes, totalStudents});
        }

        while(!pq.isEmpty()) {
            double[] arr = pq.poll();
            sum += arr[0] / arr[1];

        }
        return sum / classes.length;
    }
}
