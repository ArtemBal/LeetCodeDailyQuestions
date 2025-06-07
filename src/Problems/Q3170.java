package Problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q3170 {
    public String clearStars(String s) {
        Deque<Integer>[] characterIndices = new Deque[26];
        Arrays.setAll(characterIndices, k -> new ArrayDeque<>());
        int n = s.length();
        boolean[] remove = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '*') {
                remove[i] = true;
                for (int j = 0; j < 26; ++j) {
                    if (!characterIndices[j].isEmpty()) {
                        remove[characterIndices[j].pop()] = true;
                        break;
                    }
                }
            } else {
                characterIndices[s.charAt(i) - 'a'].push(i);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            if (!remove[i]) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
