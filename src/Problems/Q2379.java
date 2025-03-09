package Problems;

public class Q2379 {
    public int minimumRecolors(String blocks, int k) {
        int curr = 0;
        for(int i = 0; i < k; i++) {
            if(blocks.charAt(i) == 'W') {
                curr++;
            }
        }
        int min = curr;
        for(int i = k; i < blocks.length(); i++) {
            if(blocks.charAt(i) == 'W') {
                curr++;
            }
            if(blocks.charAt(i - k) == 'W') {
                curr--;
            }
            if(curr < min) {
                min = curr;
            }
        }
        return min;
    }
}
