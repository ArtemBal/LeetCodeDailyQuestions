package Problems;

public class Q2381 {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] totalShift = new int[s.length()];
        for(int[] arr: shifts) {
            int dir = arr[2] == 0 ? -1 : 1;
            for(int i = arr[0]; i <= arr[1]; i++) {
                totalShift[i] += dir;
            }
        }

        char[] ans = s.toCharArray();
        for(int i = 0; i < ans.length; i++) {
            ans[i] = (char) ('a' + (ans[i] - 'a' + totalShift[i] % 26 + 26) % 26);
        }
        return String.valueOf(ans);

    }
}
