package Problems;

import java.util.Map;
import java.util.TreeMap;

public class Q2570 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int[] arr: nums1) {
            map.merge(arr[0], arr[1], Integer::sum);
        }
        for(int[] arr: nums2) {
            map.merge(arr[0], arr[1], Integer::sum);
        }
        int[][] result = new int[map.size()][2];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[index++] = new int[]{entry.getKey(), entry.getValue()};
        }
        return result;
    }
}
