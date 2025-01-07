package Problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1408 {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        Set<String> ans = new HashSet<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j != i && words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
