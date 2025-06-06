package Problems;

import java.util.ArrayDeque;

public class Q2434 {
    public String robotWithString(String s) {
        int n = s.length();
        int[] count = new int[26];
        for(char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        int minCountIndex = findNextMin(count);
        ArrayDeque<Character> t = new ArrayDeque<>(n);
        StringBuilder ans = new StringBuilder(n);
        for(char c: s.toCharArray()) {
            while(!t.isEmpty() && (t.peekLast() - 'a') <= minCountIndex) {
                ans.append(t.pollLast());
            }
            if(c == minCountIndex + 'a' && (t.isEmpty() || (t.peekLast() - 'a') > minCountIndex)) {
                ans.append(c);
                count[minCountIndex]--;
                if(count[minCountIndex] == 0) {
                    minCountIndex = findNextMin(count);
                }
            } else {
                t.offer(c);
                count[c - 'a']--;
            }
        }
        while(!t.isEmpty()) {
            ans.append(t.pollLast());
        }
        return ans.toString();
    }

    private int findNextMin(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                return i;
            }
        }
        return 25;
    }
}
