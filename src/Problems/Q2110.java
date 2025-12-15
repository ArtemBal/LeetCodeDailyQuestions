package Problems;

public class Q2110 {
    public long getDescentPeriods(int[] prices) {
        long currPeriod = 1;
        long ans = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i] == prices[i + 1] + 1) {
                currPeriod++;
            } else {
                ans = ans + (currPeriod * (currPeriod + 1) / 2);
                currPeriod = 1;
            }
        }
        ans += currPeriod * (currPeriod + 1) /  2;
        return ans;
    }
}
