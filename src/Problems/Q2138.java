package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2138 {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        List<String> ans = new ArrayList<>(n / k + 1);
        for(int i = 0; i < n; i += k) {
            int index = 0;
            char[] curr = new char[k];
            while(index < k && i + index < n) {
                curr[index] = s.charAt(index + i);
                index++;
            }
            if(index < k) {
                Arrays.fill(curr, index, k, fill);
            }
            ans.add(new String(curr));
        }
        return ans.toArray(new String[0]);
    }
}
