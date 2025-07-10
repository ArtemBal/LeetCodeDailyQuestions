package Problems;

import java.util.HashMap;
import java.util.Map;

public class Q1865 {
    private int[] nums1;
    private int[] nums2;
    Map<Integer, Integer> map2 = new HashMap<>();

    public Q1865(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int i: nums2) {
            map2.merge(i, 1, Integer::sum);
        }
    }

    public void add(int index, int val) {
        int curr = nums2[index];
        if(map2.merge(curr, -1, Integer::sum) == 0) {
            map2.remove(curr);
        }
        nums2[index] += val;
        map2.merge(curr + val, 1, Integer::sum);
    }

    public int count(int tot) {
        int ans = 0;
        for(int i : nums1) {
            int diff = tot - i;
            ans += map2.getOrDefault(diff, 0);
        }
        return ans;
    }

}
