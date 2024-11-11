package Problems;

public class Q2275 {
    public int largestCombination(int[] candidates) {
        int max = 0;
        for (int i = 0; i < 32; ++i) {
            int count = 0;
            for(int c: candidates) {
                count += (c >> i) & 1;
            }
            if (max < count) {
                max = count;
            }
        }
        return max;
    }
}
