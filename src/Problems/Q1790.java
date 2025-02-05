package Problems;

public class Q1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int first = 0; int second = 0;
        int difCount = 0;
        for(int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(ch1 != ch2) {
                difCount++;
                if(difCount > 2) {
                    return false;
                }
                if(difCount == 1) {
                    first = i;
                } else {
                    second = i;
                }
            }
        }
        return s1.charAt(first) == s2.charAt(second) &&
                s1.charAt(second) == s2.charAt(first);
    }
}
