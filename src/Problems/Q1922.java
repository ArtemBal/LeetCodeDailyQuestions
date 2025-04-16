package Problems;

public class Q1922 {
    public int countGoodNumbers(long n) {
        int mod = (int)1e9 + 7;
        long ans = 1;
        long index = 0;
        while(index < n) {
            ans *= (index++ % 2 == 0 ? 5 : 4);
            ans %= mod;
        }
        return (int) ans;
    }
}
