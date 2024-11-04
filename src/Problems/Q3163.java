package Problems;

public class Q3163 {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index < word.length()) {
            char c = word.charAt(index);
            int count = 0;
            while(index < word.length() && c == word.charAt(index)) {
                count++;
                index++;
            }
            for(int i = 0; i < count / 9; i++) {
                sb.append(9).append(c);
            }
            if(count % 9 > 0) {
                sb.append(count % 9).append(c);
            }
        }
        return sb.toString();
    }
}
