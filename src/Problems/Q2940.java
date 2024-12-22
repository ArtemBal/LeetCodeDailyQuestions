package Problems;

import java.util.Stack;

public class Q2940 {
        public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
            int n = queries.length;
            int[][] ngh = nextGreaterHeight(heights);
            int[] ans = new int[n];
            for(int a = 0; a < n; a++) {
                int i = queries[a][0];
                int j = queries[a][1];
                ans[a] = minHeight(heights, i, j, ngh);
            }
            return ans;
        }

        public int minHeight(int[] heights, int i, int j, int[][] ngh) {
            if(i > j) {
                int temp = i;
                i = j;
                j = temp;
            }
            if(i == j || heights[j] > heights[i]) {
                return j;
            }
            if(ngh[i][0] == -1 || ngh[j][0] == -1) {
                return -1;
            }
            if(ngh[i][0] > ngh[j][0] && ngh[i][1] > j && ngh[i][0] > heights[j]) {
                return ngh[i][1];
            } else if(ngh[j][0] > heights[i]) {
                return ngh[j][1];
            } else {
                if(ngh[i][1] < ngh[j][1] && ngh[i][0] < heights[j]) {
                    i = ngh[i][1];
                } else {
                    j = ngh[j][1];
                }
                return minHeight(heights, i, j, ngh);
            }
        }

        public int[][] nextGreaterHeight(int[] nums) {
            int n = nums.length;
            int ngh[][] = new int[n][2];
            Stack<Integer> st = new Stack<>();
            Stack<Integer> positions = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                while (!st.isEmpty() && st.peek() <= nums[i]) {
                    st.pop();
                    positions.pop();
                }

                if (i < n) {
                    if (!st.isEmpty()) {
                        ngh[i][0] = st.peek();
                        ngh[i][1] = positions.peek();
                    }
                    else {
                        ngh[i][0] = -1;
                        ngh[i][1] = -1;
                    }
                }

                st.push(nums[i]);
                positions.push(i);
            }
            return ngh;
        }
}
