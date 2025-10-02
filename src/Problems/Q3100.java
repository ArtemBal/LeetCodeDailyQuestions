package Problems;

public class Q3100 {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        return helper(numBottles, 0, numExchange);
    }

    private int helper(int full, int empty, int rate) {
        empty += full;
        if(empty < rate) {
            return full;
        }
        int newFull = 0;
        while(empty >= rate) {
            newFull++;
            empty = empty - rate;
            rate++;
        }
        return full + helper(newFull, empty, rate);
    }
}
