package Problems;

public class Q1716 {
    public int totalMoney(int n) {
        int ans = 0;
        int sevenDays = 28;
        int add = 0;
        while(n >= 7) {
            ans += sevenDays;
            sevenDays += 7;
            n -= 7;
            add++;
        }
        int day = 1;
        while(n > 0) {
            ans += day + add;
            day++;
            n--;
        }
        return ans;
    }
}
