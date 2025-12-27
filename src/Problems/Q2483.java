package Problems;

public class Q2483 {
    public int bestClosingTime(String customers) {
        char[] c = customers.toCharArray();
        int n = c.length;
        int closedPen = 0;

        for(int i = 0; i < n; i++) {
            if(c[i] == 'Y') {
                closedPen++;
            }
        }
        int min = closedPen;
        int pos = 0;
        int openPen = 0;
        for(int i = 1; i <= n; i++) {
            if(c[i - 1] == 'N') {
                openPen++;
            } else {
                closedPen--;
            }
            if(min > openPen + closedPen) {
                min = openPen + closedPen;
                pos = i;
            }
        }

        return pos;
    }
}
