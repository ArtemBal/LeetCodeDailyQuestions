package Problems;

public class Q3208 {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        int curr = 1;
        for(int i = 0; i < n + k - 2; i++) {
            if(colors[i % n] != colors[(i + 1) % n]) {
                curr++;
            } else {
                curr = 1;
            }
            if(curr >= k) {
                count++;
            }
        }
        return count;
    }
}
