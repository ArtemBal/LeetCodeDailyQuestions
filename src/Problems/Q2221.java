package Problems;

public class Q2221 {
    public int triangularSum(int[] nums) {
        int[] MODS = new int[20];
        for(int i = 0; i < 20; i++) {
            MODS[i] = i % 10;
        }
        int n = nums.length - 1;
        while(n >= 0) {
            for(int i = 0; i < n; i++) {
                nums[i] = MODS[nums[i] + nums[i + 1]];
            }
            n--;
        }
        return nums[0];
    }
}
