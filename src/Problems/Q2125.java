package Problems;

public class Q2125 {
    public int numberOfBeams(String[] bank) {
        int ans = 0;
        int last = 0;
        for(String s: bank) {
            int curr = 0;
            for(char c: s.toCharArray()) {
                if(c == '1') {
                    curr++;
                }
            }
            if(curr != 0) {
                ans += last * curr;
                last = curr;
            }
        }
        return ans;
    }
}
