package Problems;

public class Q2342 {
    public int maximumSum(int[] nums) {
        int ans = -1;
        int[] maxDig = new int[100];
        for(int num: nums) {
            int sumOfDig = 0;
            for(int i = num; i > 0; i /= 10) {
                sumOfDig += i % 10;
            }
            if(maxDig[sumOfDig] > 0) {
                ans = Math.max(ans, maxDig[sumOfDig] + num);
            }
            maxDig[sumOfDig] = Math.max(maxDig[sumOfDig], num);
        }
        return ans;

    }
}
