package Problems;

public class Q3223 {
    public int minimumLength(String s) {
        int[] count = new int[26];
        for(char c: s.toCharArray()) {
            count[c - 'a']++;
        }

        int sum = 0;
        for(int i: count) {
            if(i == 0) {
                continue;
            }
            if(i % 2 == 0) {
                sum += 2;
            } else {
                sum += 1;
            }
        }
        return sum;
    }
}
