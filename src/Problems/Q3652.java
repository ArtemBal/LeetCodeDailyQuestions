package Problems;

public class Q3652 {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long original = 0;
        for(int i = 0; i < n; i++) {
            original += (long) prices[i] * strategy[i];
        }
        long[] originalWindowsSum = new long[n - k + 1];
        long window = 0;
        for(int i = 0; i < k; i++) {
            window += (long) prices[i] * strategy[i];
        }
        originalWindowsSum[0] = window;
        for(int i = k; i < n; i++) {
            window += (long) prices[i] * strategy[i];
            window -= (long) prices[i - k] * strategy[i - k];
            originalWindowsSum[i - k + 1] = window;
        }

        long newWindow = 0;
        for(int i = k / 2; i < k; i++) {
            newWindow += prices[i];
        }
        long maxDiff = newWindow - originalWindowsSum[0];
        for(int i = k; i < n; i++) {
            newWindow += prices[i];
            newWindow -= prices[i - k / 2];
            maxDiff = Math.max(newWindow - originalWindowsSum[i - k + 1], maxDiff);
        }
        return maxDiff < 0 ? original : original + maxDiff;
    }
}
