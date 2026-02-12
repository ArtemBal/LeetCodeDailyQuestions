package Problems;

public class Q3713 {
    public int longestBalanced(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int max = 0;
        for(int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for(int j = i; j < n; j++) {
                freq[c[j] - 'a']++;
                max = Math.max(max, check(freq));
            }
        }
        return max;
    }

    private int check(int[] freq) {
        int target = 0;
        int count = 0;
        for(int i: freq) {
            if(target == 0) {
                target = i;
            }
            if(i != 0) {
                count++;
                if(i != target) {
                    return 0;
                }
            }
        }
        return target * count;
    }
}
