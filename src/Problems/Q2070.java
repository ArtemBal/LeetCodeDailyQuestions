package Problems;

import java.util.Arrays;
import java.util.Comparator;

public class Q2070 {
    public int[] maximumBeauty(int[][] items, int[] queries) {

        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        int maxPrice = 0;
        for(int[] i: items) {
            if(i[0] > maxPrice) maxPrice = i[0];
        }
        int[] dp = new int[maxPrice + 1];
        int prevMax = 0;
        int prevIndex = 0;
        for(int[] i: items) {
            if(i[0] > prevIndex) {
                Arrays.fill(dp, prevIndex, i[0], prevMax);
            }
            dp[i[0]] = Math.max(prevMax, i[1]);
            prevMax = dp[i[0]];
            prevIndex = i[0];
        }
        for(int i = 0; i < queries.length; i++) {
            int n = queries[i];
            if(n > maxPrice) {
                n = maxPrice;
            }
            queries[i] = dp[n];
        }

        return queries;
    }
}
