package Problems;

public class Q3100 {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = 0;
        ans += numBottles;
        int empty = numBottles;
        while(empty >= numExchange) {
            ans++;
            empty = empty - numExchange + 1;
            numExchange++;
        }
        return ans;
    }
}
