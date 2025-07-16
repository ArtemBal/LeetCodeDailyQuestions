package Problems;

public class Q3201 {
    public int maximumLength(int[] nums) {
        int even = 0;
        int odd = 0;
        int transitions = 1;
        int prev = nums[0] % 2;
        for(int num : nums) {
            int temp = num % 2;
            if(temp == 0) {
                even++;
            } else {
                odd++;
            }
            if(temp != prev) {
                transitions++;
                prev = 1 - prev;
            }
        }
        return Math.max(transitions, Math.max(even, odd));
    }
}
