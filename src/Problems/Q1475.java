package Problems;

public class Q1475 {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        for(int i = 0; i < n - 1; i++) {
            int j = i + 1;
            while(j < n && prices[i] < prices[j]) {
                j++;
            }
            if(j < n) {
                prices[i] -= prices[j];
            }
        }
        return prices;
    }
}
