package Problems;

public class Q1922 {
    private static final int MOD = (int)1e9 + 7;
    public int countGoodNumbers(long n) {
        return (int) (helper(5, (n + 1) / 2) * helper(4, n / 2) % MOD);
    }

    private long helper(long base, long expo) {
        long res = 1;
        while(expo > 0) {
            if((expo & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            expo >>= 1;
        }
        return res;
    }
}
