package Problems;

public class Q2579 {
    public long coloredCells(int n) {
        return helper(n);
    }

    private long helper(int n) {
        if(n == 1) {
            return 1;
        }

        if(n == 2) {
            return 5;
        }

        return helper(n - 1) + (4 + ((n - 2) * 4L));
    }
}
