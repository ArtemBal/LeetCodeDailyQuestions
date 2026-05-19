package Problems;

public class Q2540 {
    public int getCommon(int[] nums1, int[] nums2) {
        int pos1 = 0;
        int pos2 = 0;
        while(pos1 < nums1.length && pos2 < nums2.length &&
                nums1[pos1] <= nums2[nums2.length - 1] && nums2[pos2] <= nums1[nums1.length - 1]) {
            if(nums1[pos1] == nums2[pos2]) {
                return nums1[pos1];
            } else if(nums1[pos1] > nums2[pos2]) {
                pos2++;
            } else {
                pos1++;
            }
        }
        return -1;
    }
}
