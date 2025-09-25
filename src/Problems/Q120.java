package Problems;

import java.util.Arrays;
import java.util.List;

public class Q120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        final int INF = 10000;
        int[] curr = new int[1];
        curr[0] = triangle.get(0).get(0);
        for(int i = 0; i < triangle.size() - 1; i++) {
            int[] next = new int[i + 2];
            Arrays.fill(next, INF);
            for(int j = 0; j < curr.length; j++) {
                int a = triangle.get(i + 1).get(j) + curr[j];
                next[j] = Math.min(a, next[j]);
                int b = triangle.get(i + 1).get(j + 1) + curr[j];
                next[j + 1] = Math.min(b, next[j + 1]);
            }
            curr = next;
        }
        return Arrays.stream(curr).min().getAsInt();
    }
}
