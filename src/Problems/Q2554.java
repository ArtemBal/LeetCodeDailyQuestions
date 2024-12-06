package Problems;

public class Q2554 {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean[] nums = new boolean[n + 1];
        for(int i: banned) {
            if(i <= n) {
                nums[i] = true;
            }
        }
        int sum = 0;
        int count = 0;
        for(int i = 1; i < nums.length && i <= maxSum; i++) {
            if(sum + i > maxSum) {
                break;
            }
            if(!nums[i]) {
                sum += i;
                count++;
            }
        }
        return count;
    }

}
