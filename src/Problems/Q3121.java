package Problems;

import java.util.Arrays;

public class Q3121 {
    public int numberOfSpecialChars(String word) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        Arrays.fill(lower, -1);
        Arrays.fill(upper, -1);
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c >= 'a' && c <= 'z') {
                lower[c - 'a'] = i;
            } else {
                if(upper[c - 'A'] == -1) {
                    upper[c - 'A'] = i;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < 26; i++) {
            if(lower[i] != -1 && upper[i] != -1 && lower[i] < upper[i]) {
                ans++;
            }
        }
        return ans;
    }
}
