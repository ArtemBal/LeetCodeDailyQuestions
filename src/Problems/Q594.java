package Problems;

import java.util.HashMap;
import java.util.Map;

public class Q594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i: nums) {
            freq.merge(i, 1, Integer::sum);
        }
        int maxSubseq = 0;
        for(var entry: freq.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(freq.containsKey(key + 1)) {
                maxSubseq = Math.max(maxSubseq, value + freq.get(key + 1));
            }
        }
        return maxSubseq;
    }
}
