package Problems;

public class Q3170 {
    public String clearStars(String s) {
        int[] count = new int[26];
        for(char c: s.toCharArray()) {
            int curr = c - 'a';
            if(c != '*') {
                count[curr]++;
            } else {
                int smallestIndex = 0;
                while(count[smallestIndex] == 0) {
                    smallestIndex++;
                }
                count[smallestIndex]--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(c == '*') {
                continue;
            }
            int curr = c - 'a';
            if(count[curr] > 0) {
                sb.append(c);
                count[curr]--;
            }
        }
        return sb.toString();
    }
}
