package Problems;

public class Q1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int ans = 0;
        int maxPair = values[0];
        for(int j = 1; j < n; j++) {
            if(values[j] - j + maxPair > ans) {
                ans = values[j] - j + maxPair;
            }
            if(values[j] + j > maxPair) {
                maxPair = values[j] + j;
            }
        }
        return ans;
    }
}
