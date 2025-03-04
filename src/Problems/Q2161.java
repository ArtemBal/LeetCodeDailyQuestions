package Problems;

import java.util.ArrayList;
import java.util.List;

public class Q2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> large = new ArrayList<>();
        int countPivot = 0;
        for(int i: nums) {
            if(i < pivot) {
                less.add(i);
            }
            if(i > pivot) {
                large.add(i);
            }
            if(i == pivot) {
                countPivot++;
            }
        }
        while(countPivot-- > 0) {
            less.add(pivot);
        }
        less.addAll(large);
        return less.stream().mapToInt(i -> i).toArray();
    }
}
