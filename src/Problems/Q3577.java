package Problems;

public class Q3577 {
    final static int MOD = (int) 1e9 + 7;
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        long ans = 0;
        int zero = complexity[0];
        for(int i = 1; i < n; i++) {
            if(complexity[i] <= zero) {
                return 0;
            }
        }
        return (int)factorial(n - 1);
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = (result * i) % MOD;
        }
        return result;
    }
}
