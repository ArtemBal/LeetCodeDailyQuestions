package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q916 {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[][] countW2 = new int[words2.length][26];
        for(int i = 0; i < words2.length; i++) {
            for(int j = 0; j < words2[i].length(); j++) {
                countW2[i][words2[i].charAt(j) - 'a']++;
            }
        }

        List<String> ans = new ArrayList<>();
        int[] countW1 = new int[26];
        for(String s: words1) {
            for(int i = 0; i < s.length(); i++) {
                countW1[s.charAt(i) - 'a']++;
            }
            boolean flag = true;
            for(int i = 0; i < words2.length; i++) {
                for(int j = 0; j < 26; j++) {
                    if(countW2[i][j] > countW1[j]) {
                        flag = false;
                        break;
                    }
                }
                if(!flag) {
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
