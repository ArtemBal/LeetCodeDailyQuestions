import java.util.HashMap;
import java.util.Map;

public class Q3583 {
    public int specialTriplets(int[] nums) {
        int MOD = (int) 1e9 + 7;
        long ans = 0;
        Map<Integer, Integer> rightFreq = new HashMap<>();
        Map<Integer, Integer> leftFreq = new HashMap<>();
        for(int i: nums) {
            rightFreq.merge(i, 1, Integer::sum);
        }
        for(int j: nums) {
            int target = j * 2;
            rightFreq.merge(j, -1, Integer::sum);
            if(rightFreq.get(j) == 0) {
                rightFreq.remove(j);
            }

            if(leftFreq.containsKey(target) && rightFreq.containsKey(target)) {
                long left = leftFreq.get(target);
                long right = rightFreq.get(target);
                long triples = (left  * right) % MOD;
                ans = (ans + triples) % MOD;
            }
            leftFreq.merge(j, 1, Integer::sum);

        }
        return (int) ans;
    }
}
