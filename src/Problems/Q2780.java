package Problems;

import java.util.List;

public class Q2780 {
    public int minimumIndex(List<Integer> nums) {
        int[] major = majorityElement(nums);
        int dominant = major[0];
        int dominantCount = major[1];
        if(dominantCount < nums.size() / 2) {
            return -1;
        }
        int otherCount = nums.size() - dominantCount;
        int index = -1;
        int leftDomCount = 0;
        int leftOtherCount = 0;
        for(int i: nums) {
            if(i == dominant) {
                leftDomCount++;
            } else {
                leftOtherCount++;
            }
            index++;
            if(leftDomCount > leftOtherCount && dominantCount - leftDomCount > otherCount - leftOtherCount) {
                return index;
            }
        }
        return -1;
    }

    private static int[] majorityElement(List<Integer> arr) {
        int n = arr.size();
        int candidate = -1;
        int count = 0;

        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }

        return new int[] {candidate, count};
    }
}
