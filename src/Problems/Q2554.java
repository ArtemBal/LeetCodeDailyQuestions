package Problems;

public class Q2554 {
    public int maxCount(int[] banned, int n, int maxSum) {
        int[] nums = new int[n + 1];
        for(int i: banned) {
            if(i <= n) {
                nums[i] = 1;
            }
        }
        int sum = 0;
        int count = 0;
        for(int i = 1; i < nums.length && i <= maxSum; i++) {
            if(nums[i] == 0) {
                if(sum + i > maxSum) {
                    break;
                }
                sum += i;
                count++;
            }
        }
        return count;
    }
}
