package Problems;

import java.util.HashMap;
import java.util.Map;

public class Q3160 {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] balls = new int[limit + 1];
        Map<Integer, Integer> countMap = new HashMap<>();

        int[] result = new int[n];

        int currDist = 0;
        for(int i = 0; i < n; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            if(countMap.merge(y, 1, Integer::sum) == 1) {
                currDist++;
            }
            if(balls[x] != 0) {
                if(countMap.merge(balls[x], -1, Integer::sum) == 0) {
                    currDist--;
                    countMap.remove(balls[x]);
                }
            }
            balls[x] = y;
            result[i] = currDist;
        }
        return result;
    }
}
