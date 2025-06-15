package Problems;

public class Q1432 {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        //find first dig that != 9
        char firstNotNine = '9'; // if num contains only 9 we'll change 9 -> 9
        for(char c: s.toCharArray()) {
            if(c != '9') {
                firstNotNine = c;
                break;
            }
        }
        //check if first dig is 1 and if it is find first that is bigger than 1
        boolean isFirstIsOne = s.charAt(0) == '1';
        char first = s.charAt(0); //if num contains only 1 and 0 we'll change 1 -> 1
        if(isFirstIsOne && s.length() > 1) {
            for(char c: s.toCharArray()) {
                if(c != '1' && c != '0') {
                    first = c;
                    break;
                }
            }
        }

        char[] min = s.toCharArray();
        char[] max = s.toCharArray();

        //find max possible
        for(int i = 0; i < n; i++) {
            if(max[i] == firstNotNine) {
                max[i] = '9';
            }
        }
        //find min possible
        if(isFirstIsOne && first != '1') { //check if num contains only 1 and 0 (which means it is already min possible)
            for(int i = 1; i < n; i++) {
                if(min[i] == first) {
                    min[i] = '0';
                }
            }
        } else {
            for(int i = 0; i < n; i++) {
                if(min[i] == first) {
                    min[i] = '1';
                }
            }
        }
        //System.out.println(Integer.parseInt(new String(max)) + " " + Integer.parseInt(new String(min)));
        return Integer.parseInt(new String(max)) - Integer.parseInt(new String(min));
    }
}
