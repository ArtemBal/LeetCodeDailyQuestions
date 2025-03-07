package Problems;

public class Q2965 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n * n + 1];
        for(int[] arr: grid) {
            for(int i: arr) {
                count[i]++;
            }
        }
        int twice = 0;
        int zero = 0;
        for(int i = 1; i < count.length; i++) {
            if(count[i] == 0) {
                zero = i;
            }
            if(count[i] == 2) {
                twice = i;
            }
        }
        return new int[]{twice, zero};
    }
}
