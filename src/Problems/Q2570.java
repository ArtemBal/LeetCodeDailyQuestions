package Problems;

import java.util.ArrayList;
import java.util.List;

public class Q2570 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        List<int[]> res = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while(index1 < nums1.length && index2 < nums2.length) {
            if(nums1[index1][0] < nums2[index2][0]) {
                res.add(nums1[index1]);
                index1++;
            } else if(nums1[index1][0] > nums2[index2][0]) {
                res.add(nums2[index2]);
                index2++;
            } else {
                res.add(new int[]{nums1[index1][0], nums1[index1][1] + nums2[index2][1]});
                index1++;
                index2++;
            }
        }
        while(index1 < nums1.length) {
            res.add(nums1[index1++]);
        }
        while(index2 < nums2.length) {
            res.add(nums2[index2++]);
        }
        return res.toArray(new int[res.size()][]);
    }
}
