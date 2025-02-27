package Problems;

public class Q873 {
    public int lenLongestFibSubseq(int[] arr) {
        int max = 0;
        int n = arr.length;
        int[] last = new int[2];
        for(int  i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                last[0] = arr[i];
                last[1] = arr[j];
                int curr = j + 1;
                int currCount = 2;
                while(curr < n) {
                    if(arr[curr] == last[0] + last[1]) {
                        last[0] = last[1];
                        last[1] = arr[curr];
                        currCount++;
                    }
                    curr++;
                }
                max = Math.max(max, currCount);
            }
        }
        return max < 3 ? 0 : max;
    }
}
