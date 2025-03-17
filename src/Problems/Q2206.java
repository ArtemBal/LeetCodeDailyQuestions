package Problems;

public class Q2206 {
    public boolean divideArray(int[] nums) {
        boolean[] count = new boolean[501];
        for(int i: nums) {
            count[i] = !count[i];
        }
        for(boolean b: count) {
            if(b) {
                return false;
            }
        }
        return true;
    }
}
