package Problems;

import java.util.ArrayList;
import java.util.List;

public class Q1415 {
    private List<String> strings = new ArrayList<>();

    public String getHappyString(int n, int k) {
        dfs("", n);
        return strings.size() >= k ? strings.get(k - 1) : "";
    }

    private void dfs(String str, int n) {
        if(str.length() == n) {
            strings.add(str);
            return;
        }
        for(char c : "abc".toCharArray()) {
            if(!str.isEmpty() && str.charAt(str.length() - 1) == c) {
                continue;
            }
            dfs(str + c, n);
        }
    }
}
