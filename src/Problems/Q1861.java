package Problems;

public class Q1861 {
    public char[][] rotateTheBox(char[][] box) {
        int rows = box.length;
        int cols = box[0].length;

        for(int i = 0; i < rows; i++) {
            int lowestPoint = cols - 1;
            for(int j = cols - 1; j >= 0; j--) {
                if(box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][lowestPoint] = '#';
                    lowestPoint--;
                }
                if(box[i][j] == '*') {
                    lowestPoint = j - 1;
                }
            }
        }
        //rotate
        char[][] ans = new char[cols][rows];
        for (int r = 0, cc = rows - 1; r < rows; ++r, --cc){
            for (int c = 0, rr = 0; c < cols; ++c, ++rr) {
                ans[rr][cc] = box[r][c];
            }
        }
        return ans;
    }
}
