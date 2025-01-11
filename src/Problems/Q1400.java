package Problems;

public class Q1400 {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k) {
            return false;
        }
        int[] count = new int[26];
        for(char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        int singleCount = 0;
        for(int i: count) {
            singleCount += i % 2;
        }
        return singleCount <= k;
    }
}
