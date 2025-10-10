package Problems;

public class Q3147 {
    public int maximumEnergy(int[] energy, int k) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < k; i++) {
            int curr = 0;
            int j = energy.length - 1 - i;
            while(j >= 0) {
                curr += energy[j];
                max = Math.max(max, curr);
                j -= k;
            }
        }
        return max;
    }
}
