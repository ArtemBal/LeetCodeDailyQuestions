package Problems;

import java.util.Arrays;

public class Q2523 {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = sieveOfEratosthenes(right);
        int[] ans = new int[]{-1, -1};
        int last = 0;
        int min = Integer.MAX_VALUE;
        for(int i = left; i <= right; i++) {
            if(isPrime[i]) {
                if(last != 0 && min > i - last) {
                    min = i - last;
                    ans[0] = last;
                    ans[1] = i;
                }
                last = i;
            }
        }
        return ans;
    }

    static boolean[] sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        return prime;
    }
}
