package Problems;

public class Q2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] count = new int[n];
        int[] ans = new int[n];
        int curr = 0;
        for(int i = 0; i < n; i++) {
            count[A[i] - 1]++;
            if(count[A[i] - 1] == 2) {
                curr++;
            }
            count[B[i] - 1]++;
            if(count[B[i] - 1] == 2) {
                curr++;
            }
            ans[i] = curr;
        }
        return ans;
    }
}
