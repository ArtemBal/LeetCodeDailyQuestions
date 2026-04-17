package Problems;

import java.util.HashMap;
import java.util.Map;

public class Q3761 {
    public int minMirrorPairDistance(int[] nums) {
        Map<Long, Integer> mirrorLastPositions = new HashMap<>(nums.length * 2);
        int minDistance = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            long value = nums[i];
            long mirror = reverse(value);
            if(mirrorLastPositions.containsKey(value)) {
                minDistance = Math.min(minDistance, i - mirrorLastPositions.get(value));
            }
            mirrorLastPositions.put(mirror, i);
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private long reverse(long n) {
        long reversed = 0;
        while (n != 0) {
            reversed = reversed * 10 + (n % 10);
            n /= 10;
        }
        return reversed;
    }
}
