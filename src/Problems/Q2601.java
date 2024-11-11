package Problems;

import java.util.TreeSet;

public class Q2601 {
    TreeSet<Integer> primes = new TreeSet<>();

    public boolean primeSubOperation(int[] nums) {
        for(int i = 1; i <= 1000; i++) {
            if(isPrime(i)) {
                primes.add(i);
            }
        }

        for(int i = nums.length - 2; i >= 0 ; i--) {
            if(nums[i] < nums[i + 1]) {
                continue;
            }
            Integer p = primes.higher(nums[i] - nums[i + 1]);
            if(p == null || p > nums[i] || nums[i] - p <= 0) {
                return false;
            }
            nums[i] = nums[i] - p;
        }
        return true;
    }

    public static boolean isPrime(int n) {
        if (n == 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
