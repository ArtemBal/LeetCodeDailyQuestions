package Problems;

public class Q769 {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int next = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > i) {
                next = arr[i];
                do {
                    i++;
                    if(next < arr[i]) {
                        next = arr[i];
                    }
                } while(i != next);
            }
            count++;
        }
        return count;
    }
}
