package Problems;

public class Q3170 {
    public String clearStars(String s) {
        int[] count = new int[26];
        StringBuilder sb = new StringBuilder(s.length());
        for(char c: s.toCharArray()) {

            if(c != '*') {
                int curr = c - 'a';
                sb.append(c);
                count[curr]++;
            } else {
                int smallestIndex = 0;
                while(count[smallestIndex] == 0) {
                    smallestIndex++;
                }
                sb.deleteCharAt(sb.lastIndexOf((char)(smallestIndex + 'a') + ""));
                count[smallestIndex]--;
            }
        }
        return sb.toString();
    }

}
