package Problems;

import java.util.Arrays;

public class Q869 {
    public boolean reorderedPowerOf2(int n) {
        int[] arr = convert(n);
        int power = 1;
        int step = 0;
        while(step < 32) {
            int[] temp = convert(power);
            if(Arrays.equals(temp, arr)) {
                return true;
            }
            power *= 2;
            step++;
        }
        return false;
    }

    private int[] convert(int n) {
        int[] res = new int[10];
        while(n > 0) {
            res[n % 10]++;
            n /= 10;
        }
        return res;
    }
}
