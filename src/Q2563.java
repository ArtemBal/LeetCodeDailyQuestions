import java.util.Arrays;

public class Q2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int leftBoundaryIndex = binarySearch(nums, lower - nums[i], i + 1);
            int rightBoundaryIndex = binarySearch(nums, upper - nums[i] + 1, i + 1);

            count += rightBoundaryIndex - leftBoundaryIndex;
        }
        return count;
    }

    private int binarySearch(int[] nums, int target, int startIdx) {
        int endIdx = nums.length;
        while (startIdx < endIdx) {
            int midIdx = (startIdx + endIdx) >> 1;
            if (nums[midIdx] >= target) {
                endIdx = midIdx;
            } else {
                startIdx = midIdx + 1;
            }
        }
        return startIdx;
    }
}
