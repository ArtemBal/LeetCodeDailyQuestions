package Problems;

public class Q2438 {
    public int[] productQueries(int n, int[][] queries) {
        final int MOD = (int)1e9 + 7;
        int[] powers = new int[Integer.bitCount(n)];
        for(int i = 0; i < powers.length; i++) {
            int lowestSetBit = n & -n;
            powers[i] = lowestSetBit;
            n -= lowestSetBit;

        }

        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            long product = 1;
            for(int j = left; j <= right; j++) {
                product = (product * powers[j]) % MOD;
            }
            ans[i] = (int) product;
        }
        return ans;
    }
}
