package Problems;

import java.util.PriorityQueue;

public class Q3264 {
    public int[] getFinalState(int[] arr, int k, int multiplier) {
        int[] ans = new int[arr.length];
        while(k > 0)
        {
            int x = 0;
            for(int i = 1; i < arr.length; i++)
            {
                if(arr[i] < arr[x])
                {
                    x = i;
                }
            }
            arr[x] *= multiplier;
            k--;
        }
        return arr;
    }
}
