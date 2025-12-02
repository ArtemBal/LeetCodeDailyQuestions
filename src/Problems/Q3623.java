package Problems;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Q3623 {
    public int countTrapezoids(int[][] points) {
        int MOD = (int) 1e9 + 7;
        long parallelSidesToX = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for(int[] a: points) {
            int x = a[0];
            int y = a[1];
            parallelSidesToX = (parallelSidesToX + freq.merge(y, 1, Integer::sum) - 1) % MOD;
        }
        long ans = 0;
        for(var e: freq.entrySet()) {
            int k = e.getKey();
            long v = e.getValue();
            long sides = v * (v - 1) / 2;
            parallelSidesToX = Math.abs(parallelSidesToX - sides);
            ans += modMultiply(parallelSidesToX, sides, MOD);
            ans = ans % MOD;
        }
        return (int) ans;
    }

    public static long modMultiply(long a, long b, long M) {
        long result = a * b; // Potential for overflow if a and b are very large
        long finalResult = result % M;

        // Adjust for negative results of the % operator if necessary
        if (finalResult < 0) {
            finalResult += M;
        }
        return finalResult;
    }
}
