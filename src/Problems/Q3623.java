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
        BigInteger ans = new BigInteger("0");
        BigInteger allSides = new BigInteger(String.valueOf(parallelSidesToX));
        for(var e: freq.entrySet()) {
            int k = e.getKey();
            int v = e.getValue();
            BigInteger sides = new BigInteger(String.valueOf((long)v * (v - 1) / 2));
            allSides = allSides.subtract(sides).abs();
            ans = ans.add(allSides.multiply(sides)).mod(new BigInteger(String.valueOf(MOD)));
        }
        return ans.intValue();
    }
}
