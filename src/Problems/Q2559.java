package Problems;

import java.util.Set;

public class Q2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] count = new int[n + 1];
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        for(int i = 0; i < n; i++) {
            char start = words[i].charAt(0);
            char end = words[i].charAt(words[i].length() - 1);
            if(vowels.contains(start) && vowels.contains(end)) {
                count[i + 1]++;
            }
            count[i + 1] += count[i];
        }

        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            ans[i] = count[end + 1] - count[start];
        }
        return ans;
    }
}
