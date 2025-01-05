package Problems;

public class Q2381 {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] totalShift = new int[s.length() + 1];
        for(int[] arr: shifts) {
            int dir = arr[2] == 0 ? -1 : 1;
            totalShift[arr[0]] += dir;
            totalShift[arr[1] + 1] -= dir;
        }

        for(int i = 1; i < totalShift.length; i++) {
            totalShift[i] += totalShift[i - 1];
        }

        char[] ans = s.toCharArray();
        for(int i = 0; i < ans.length; i++) {
            ans[i] = (char) ('a' + (ans[i] - 'a' + totalShift[i] % 26 + 26) % 26);
        }
        return String.valueOf(ans);

    }
}
