package Problems;

public class Q2419 {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int curr = 0;
        int maxSeq = 1;
        for(int i: nums) {
            if(i > max) {
                max = i;
                curr = 1;
                maxSeq = 1;
            } else if(i == max) {
                curr++;
                maxSeq = Math.max(curr, maxSeq);
            } else {
                curr = 0;
            }
        }
        return maxSeq;
    }
}
