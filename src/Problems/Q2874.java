package Problems;

public class Q2874 {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans = 0;
        long maxD = 0;
        long maxI = 0;
        for(int i: nums) {
            ans = Math.max(ans, maxD * i);
            maxD = Math.max(maxD, maxI - i);
            maxI = Math.max(maxI, i);
        }
        return ans;
    }
}
