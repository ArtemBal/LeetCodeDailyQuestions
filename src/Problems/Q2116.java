package Problems;

public class Q2116 {
    public boolean canBeValid(String s, String locked) {
        if(s.length() % 2 == 1) {
            return false;
        }
        int n = s.length();
        int countLeft = 0;
        for(int i = 0; i < n; i++) {
            if(locked.charAt(i) == '1' && s.charAt(i) == ')') {
                countLeft--;
            } else {
                countLeft++;
            }
            if(countLeft < 0) {
                return false;
            }
        }
        int countRight = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(locked.charAt(i) == '1' && s.charAt(i) == '(') {
                countRight--;
            } else {
                countRight++;
            }
            if(countRight < 0) {
                return false;
            }
        }
        return true;
    }
}
