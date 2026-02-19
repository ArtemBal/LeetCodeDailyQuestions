package Problems;

public class Q696 {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        boolean checkZeros = s.charAt(0) == '0';
        int prev = 0;
        int curr = 0;
        for(char c: s.toCharArray()) {
            if((checkZeros && c == '0') || (!checkZeros && c == '1')) {
                curr++;
            } else {
                ans += Math.min(prev, curr);
                prev = curr;
                curr = 1;
                checkZeros = !checkZeros;
            }
        }
        ans += Math.min(prev, curr);
        return ans;
    }
}
