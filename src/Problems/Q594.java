package Problems;

import java.util.TreeMap;

public class Q594 {
    public int findLHS(int[] nums) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for(int i: nums) {
            freq.merge(i, 1, Integer::sum);
        }
        int maxSubseq = 0;
        int prevK = freq.firstKey();
        int prevV = freq.get(prevK);
        for(var entry: freq.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(key - prevK == 1) {
                maxSubseq = Math.max(maxSubseq, prevV + value);
            }
            prevK = key;
            prevV = value;
        }
        return maxSubseq;
    }
}
