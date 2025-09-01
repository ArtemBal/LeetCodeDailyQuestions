package Problems;

import java.util.Arrays;

public class Q36 {
    public boolean isValidSudoku(char[][] board) {
        int[] count = new int[10];
        for(char[] a: board) {
            for(int i = 0; i < 9; i++) {
                if(a[i] != '.') {
                    int temp = a[i] - '0';
                    count[temp]++;
                    if(count[temp] > 1) {
                        return false;
                    }
                }
            }
            Arrays.fill(count, 0);
        }
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[j][i] != '.') {
                    int temp = board[j][i] - '0';
                    count[temp]++;
                    if(count[temp] > 1) {
                        return false;
                    }
                }
            }
            Arrays.fill(count, 0);
        }
        for(int i = 0; i < 9; i += 3) {
            for(int j = 0; j < 9; j += 3) {
                for(int k = i; k < i + 3; k++) {
                    for(int l = j; l < j + 3; l++) {
                        if(board[k][l] != '.') {
                            int temp = board[k][l] - '0';
                            count[temp]++;
                            if(count[temp] > 1) {
                                return false;
                            }
                        }
                    }
                }
                Arrays.fill(count, 0);
            }
        }
        return true;
    }
}
