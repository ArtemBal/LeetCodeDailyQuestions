package Problems;

import java.util.HashSet;
import java.util.Set;

public class Q1930 {
    public int countPalindromicSubsequence(String s) {
        int count = 0;
        for (char currentChar = 'a'; currentChar <= 'z'; ++currentChar) {
            int left = s.indexOf(currentChar);
            int right = s.lastIndexOf(currentChar);

            Set<Character> unique = new HashSet<>();

            for(int i = left + 1; i < right; i++) {
                unique.add(s.charAt(i));
            }
            count += unique.size();
        }
        return count;
    }
}
