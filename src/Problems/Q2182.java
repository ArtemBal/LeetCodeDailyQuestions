package Problems;

public class Q2182 {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[27];
        for(char c: s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int lastChar = -1;
        for(int i = 26; i >= 0; i--) {
            if(count[i] != 0 && i > lastChar) {
                lastChar = i;
                for(int j = 0; j < repeatLimit; j++) {
                    sb.append((char)('a' + i));
                    count[i]--;
                    if(count[i] == 0) {
                        lastChar = -1;
                        break;
                    }
                }
                i = 26;
            }
            if(count[i] != 0 && i < lastChar) {
                sb.append((char)('a' + i));
                count[i]--;
                lastChar = i;
                i = 26;
            }
        }
        return sb.toString();
    }
}
