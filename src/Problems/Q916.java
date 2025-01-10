package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q916 {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxCountW2 = new int[26];
        int[] curr = new int[26];
        for(String s: words2) {
            for(int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                curr[index]++;
                if(curr[index] > maxCountW2[index]) {
                    maxCountW2[index] = curr[index];
                }
            }
            Arrays.fill(curr, 0);
        }

        List<String> ans = new ArrayList<>();
        int[] countW1 = new int[26];
        for(String s: words1) {
            for(int i = 0; i < s.length(); i++) {
                countW1[s.charAt(i) - 'a']++;
            }
            boolean flag = true;
            for(int i = 0; i < 26; i++) {
                if(countW1[i] < maxCountW2[i]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                ans.add(s);
            }
            Arrays.fill(countW1, 0);
        }

        return ans;
    }
}
