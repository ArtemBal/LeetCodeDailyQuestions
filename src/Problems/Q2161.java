package Problems;

import java.util.Arrays;

public class Q2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        int index = 0;
        int countPivots = 0;
        for(int i: nums) {
            if(i < pivot) {
                res[index++] = i;
            }
            if(i == pivot) {
                countPivots++;
            }
        }
        Arrays.fill(res, index, index + countPivots, pivot);
        index += countPivots;
        for(int i: nums) {
            if(i > pivot) {
                res[index++] = i;
            }
        }
        return res;
    }
}
