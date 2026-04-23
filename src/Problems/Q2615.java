package Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Q2615 {
    public long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, ArrayList<Integer>> mapValPositions = new HashMap<>();
        for(int i = 0; i < n; i++) {
            mapValPositions.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        long[] ans = new long[n];
        for(int i = 0; i < n; i++) {
            if(ans[i] != 0) {
                continue;
            }
            var list = mapValPositions.get(nums[i]);
            int currAmount = list.size();
            if(currAmount == 1) {
                ans[i] = 0;
                continue;
            }

            long totalLeft = 0;
            long totalRight = 0;
            for(int pos: list) {
                totalRight += pos;
            }
            for(int j = 0; j < currAmount; j++) {
                int pos = list.get(j);
                ans[pos] =  Math.abs((totalRight - (1L * pos * (currAmount - j)))) + Math.abs((1L * pos * j) - totalLeft);
                totalRight -= pos;
                totalLeft += pos;
            }
        }
        return ans;
    }
}
