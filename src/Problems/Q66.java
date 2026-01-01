package Problems;

public class Q66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        if(onlyNines(digits)) {
            int[] ans = new int[n + 1];
            ans[0] = 1;
            return ans;
        }
        int i = n - 1;
        while(digits[i] == 9) {
            digits[i--] = 0;
        }
        digits[i]++;
        return digits;
    }

    private boolean onlyNines(int[] digits) {
        for(int i: digits) {
            if(i != 9) {
                return false;
            }
        }
        return true;
    }
}
