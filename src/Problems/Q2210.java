package Problems;

public class Q2210 {
    public int countHillValley(int[] nums) {
        int count = 0;
        int n = nums.length;
        int last = nums[0];
        for(int i = 1; i < n - 1; i++) {
            int curr = nums[i];
            while(i < n - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
            int next = nums[i + 1];
            if((curr > last && curr > next) || (curr < last && curr < next)) {
                count++;
            }
            last = curr;
        }
        return count;
    }
}
