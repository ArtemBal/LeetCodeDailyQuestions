package Problems;

public class Q2566 {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        char firstNotNine = '9';
        char first = s.charAt(0);
        for(char c: s.toCharArray()) {
            if(c != '9') {
                firstNotNine = c;
                break;
            }
        }
        char[] min = s.toCharArray();
        char[] max = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == firstNotNine) {
                max[i] = '9';
            }
            if(s.charAt(i) == first) {
                min[i] = '0';
            }
        }
        return Integer.parseInt(new String(max)) - Integer.parseInt(new String(min));
    }
}
