package Problems;

public class Q2438 {
    public int[] productQueries(int n, int[][] queries) {
        final int MOD = (int)1e9 + 7;
        String binary = Integer.toBinaryString(n);
        int[] powers = new int[Integer.bitCount(n)];
        int index = 0;
        for(int i = binary.length() - 1; i >= 0 ; i--) {
            if(binary.charAt(i) == '1') {
                powers[index] = (int)Math.pow(2, binary.length() - 1 - i);
                index++;
            }
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
