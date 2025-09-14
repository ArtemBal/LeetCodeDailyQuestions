package Problems;

import java.util.HashMap;
import java.util.HashSet;

public class Q966 {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        var exact = new HashSet<String>();
        var caseInsensitive = new HashMap<String, String>();
        var vowelInsensitive = new HashMap<String, String>();
        for(String word: wordlist) {
            exact.add(word);

            String lowerCase = word.toLowerCase();
            caseInsensitive.putIfAbsent(lowerCase, word);

            String vowelCase = vowelsToWildcards(lowerCase);
            vowelInsensitive.putIfAbsent(vowelCase, word);
        }

        String[] ans = new String[queries.length];
        for(int i = 0; i < queries.length; i++) {
            String curr = queries[i];
            if(exact.contains(curr)) {
                ans[i] = curr;
                continue;
            }

            String lowerCase = curr.toLowerCase();
            if(caseInsensitive.containsKey(lowerCase)) {
                ans[i] = caseInsensitive.get(lowerCase);
                continue;
            }

            String vowelCase = vowelsToWildcards(lowerCase);
            if(vowelInsensitive.containsKey(vowelCase)) {
                ans[i] = vowelInsensitive.get(vowelCase);
                continue;
            }
            ans[i] = "";
        }
        return ans;
    }

    private String vowelsToWildcards(String word) {
        String vowels = "aeiou";
        char[] c = word.toCharArray();
        for(int i = 0; i < c.length; i++) {
            if(vowels.indexOf(c[i]) != -1) {
                c[i] = '*';
            }
        }
        return String.valueOf(c);
    }
}
