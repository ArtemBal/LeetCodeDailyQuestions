package Problems;

public class Q1422 {
    public int maxScore(String s) {
        int n = s.length();
        int[] score = new int[n];

        score[0] = s.charAt(0) == '0' ? 1 : 0;
        int max = Math.max(score[0], 0);
        for(int i = 1; i < n - 1; i++) {
            score[i] = s.charAt(i) == '0' ? score[i - 1] + 1 : score[i - 1];
            if(score[i] > max) {
                max = score[i];
            }
        }

        score[n - 1] = s.charAt(n - 1) == '1' ? score[n - 2] + 1 : score[n - 2];
        max = Math.max(score[n - 1], max);
        for(int i = n - 2; i > 0; i--) {
            if(s.charAt(i) == '1') {
                score[i] = score[i + 1] + 1;
            } else {
                score[i] = score[i + 1] - 1;
            }

            if(score[i] > max) {
                max = score[i];
            }
        }
        return max;
    }
}
