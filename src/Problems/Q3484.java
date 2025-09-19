package Problems;

public class Q3484 {
    private final int[][] cells;

    public Q3484(int rows) {
        cells = new int[rows][26];
    }

    public void setCell(String cell, int value) {
        cells[Integer.parseInt(cell.substring(1)) - 1][cell.charAt(0) - 'A'] = value;
    }

    public void resetCell(String cell) {
        cells[Integer.parseInt(cell.substring(1)) - 1][cell.charAt(0) - 'A'] = 0;
    }

    public int getValue(String formula) {
        String[] XY = formula.substring(1).split("\\+");
        int x = helper(XY[0]);
        int y = helper(XY[1]);
        return x + y;
    }

    private int helper(String s) {
        if(Character.isDigit(s.charAt(0))) {
            return Integer.parseInt(s);
        }
        return cells[Integer.parseInt(s.substring(1)) - 1][s.charAt(0) - 'A'];
    }
}
