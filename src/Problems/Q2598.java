package Problems;

public class Q2598 {
    public int findSmallestInteger(int[] nums, int value) {
        int[] rem = new int[value];
        for(int i: nums) {
            int temp = ((i % value) + value) % value;
            rem[temp]++;
        }
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 0; i < value; i++) {
            if(rem[i] < min) {
                min = rem[i];
                index = i;
            }
        }
        return value * min + index;
    }
}
