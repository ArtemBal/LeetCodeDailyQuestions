package Problems;

public class Q1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] count = new int[26];
        int difCount = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                difCount++;
            }
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if(difCount > 2) {
            return false;
        }
        for(int i: count) {
            if(i > 0) {
                return false;
            }
        }
        return true;
    }
}
