package Problems;

import java.util.Arrays;

public class Q3075 {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long sum = 0;
        long taken = 0;
        for(int i = n - 1; i >= n - k; i--) {
            if(happiness[i] >= taken) {
                sum += happiness[i];
                taken++;
            } else {
                break;
            }
        }
        taken--;
        return sum - taken * (taken + 1) / 2;
    }
}
