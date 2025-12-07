package Problems;

public class Q1523 {
    public int countOdds(int low, int high) {
        int all = high - low + 1;
        if(all % 2 == 0 || low % 2 == 0) {
            return all / 2;
        }
        return all / 2 + 1;
    }
}
