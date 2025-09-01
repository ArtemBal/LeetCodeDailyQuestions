package Problems;

import java.util.ArrayList;
import java.util.List;

public class Q37 {
    private char[][] board;
    boolean[][] rows;
    boolean[][] cols;
    boolean[][][] boxes;
    List<Integer> empty;
    boolean finished;
    public void solveSudoku(char[][] board) {
        this.board = board;
        rows = new boolean[9][9];
        cols = new boolean[9][9];
        boxes = new boolean[3][3][9];
        empty = new ArrayList<>(81);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    empty.add(i * 9 + j);
                } else {
                    int temp = board[i][j] - '1';
                    rows[i][temp] = true;
                    cols[j][temp] = true;
                    boxes[i / 3][j / 3][temp] = true;
                }
            }
        }
        backtrack(0);
    }

    private void backtrack(int index) {
        if(index == empty.size()) {
            finished = true;
            return;
        }
        int row = empty.get(index) / 9;
        int col = empty.get(index) % 9;
        for(int i = 0; i < 9; i++) {
            if(!rows[row][i] && !cols[col][i] && !boxes[row / 3][col / 3][i]) {
                rows[row][i] = true;
                cols[col][i] = true;
                boxes[row / 3][col / 3][i] = true;
                board[row][col] = (char)(i + '1');
                backtrack(index + 1);
                rows[row][i] = false;
                cols[col][i] = false;
                boxes[row / 3][col / 3][i] = false;
            }
            if(finished) {
                return;
            }
        }

    }
}
