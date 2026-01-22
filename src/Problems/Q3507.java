package Problems;

public class Q3507 {
    public int minimumPairRemoval(int[] nums) {
        int ans = 0;
        int pos = isSorted(nums);
        while(pos != -1) {
            int[] temp = new int[nums.length - 1];
            System.arraycopy(nums, 0, temp, 0, pos);
            temp[pos] = nums[pos] + nums[pos + 1];
            System.arraycopy(nums, pos + 2, temp, pos + 1, nums.length - pos - 2);
            nums = temp;
            pos = isSorted(nums);
            ans++;
        }
        return ans;
    }

    private int isSorted(int[] nums) {
        boolean sorted = true;
        int minPos = -1;
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                sorted = false;
            }
            int temp = nums[i] + nums[i + 1];
            if(temp < minVal) {
                minPos = i;
                minVal = temp;
            }
        }
        return sorted ? -1 : minPos;
    }
}
