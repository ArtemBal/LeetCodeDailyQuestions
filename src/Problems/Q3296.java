package Problems;

public class Q3296 {
    private static final double EPS = 1e-7;

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int min = workerTimes[0];
        for(int n: workerTimes) {
            min = Math.min(n, min);
        }
        long l = 1;
        long r = ((long) min * mountainHeight * (mountainHeight + 1)) / 2;
        if(workerTimes.length == 1) {
            return r;
        }

        long ans = 0;
        while(l <= r) {
            long mid = (r - l) / 2 + l;
            long curr = calculateTotalWork(mid, workerTimes);
            if(curr >= mountainHeight) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    private long calculateTotalWork(long seconds, int[] arr) {
        long ans = 0;
        for(int n: arr) {
            long temp = seconds / n;
            long k = (long) ((-1.0 + Math.sqrt(1 + temp * 8)) / 2 + EPS);
            ans += k;
        }
        return ans;
    }
}
