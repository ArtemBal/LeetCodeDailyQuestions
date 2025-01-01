package Problems;

public class Q1422 {
    public int maxScore(String s) {
        int n = s.length();
        int zero = s.charAt(0) == '0' ? 1 : 0;
        int max = zero;
        for(int i = 1; i < n - 1; i++) {
            if(s.charAt(i) == '0') {
                zero++;
                max = zero;
            }
        }

        int zeroOne = s.charAt(n - 1) == '1' ? zero + 1 : zero;
        max = Math.max(zeroOne, max);
        for(int i = n - 2; i > 0; i--) {
            if(s.charAt(i) == '1') {
                zeroOne++;
            } else {
                zeroOne--;
            }

            if(zeroOne > max) {
                max = zeroOne;
            }
        }
        return max;
    }
}
