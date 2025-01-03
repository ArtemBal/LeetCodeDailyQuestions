package Problems;

public class Q2270 {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for(int i : nums) {
            sum += i;
        }
        int count = 0;
        long temp = 0;

        for(int i = 0; i < n - 1; i++){
            temp += nums[i];
            if(temp >= sum - temp) {
                count++;
            }
        }
        return count;
    }
}
