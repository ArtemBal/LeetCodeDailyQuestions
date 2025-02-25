package Problems;

public class Q1524 {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int oddCount = 0;
        int evenCount = 0;
        long total = 0;
        int ans = 0;
        for(int i: arr) {
            total += i;
            if(total % 2 == 1) {
                ans += evenCount + 1;
                oddCount++;
            } else {
                ans += oddCount;
                evenCount++;
            }
            ans = ans % MOD;
        }
        return ans;
    }
}
