package Problems;

public class Q14 {
    public String longestCommonPrefix(String[] strs) {
        int min = 201;
        if(strs.length == 0) {
            return "";
        }
        for(String s: strs) {
            if(min > s.length()) {
                min = s.length();
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < min; i++) {
            char c = strs[0].charAt(i);
            boolean f = true;
            for (String str : strs) {
                if (str.charAt(i) != c) {
                    f = false;
                    break;
                }
            }
            if(f) {
                ans.append(c);
            } else {
                break;
            }
        }
        return ans.toString();
    }
}
