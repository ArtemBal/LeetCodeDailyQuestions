package Problems;

import java.util.HashMap;
import java.util.Map;

public class Q3160 {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        Map<Integer, Integer> groups = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        int[] result = new int[n];

        int currDist = 0;
        for(int i = 0; i < n; i++) {
            int x = queries[i][0];
            int y = queries[i][1];

            countMap.merge(y, 1, Integer::sum);
            if(groups.containsKey(x)) {
                int temp = groups.get(x);
                if(countMap.merge(temp, -1, Integer::sum) == 0) {
                    countMap.remove(temp);
                }
            }
            groups.put(x, y);
            result[i] = countMap.size();
        }
        return result;
    }
}
