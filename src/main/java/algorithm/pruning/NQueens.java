package algorithm.pruning;

import java.util.HashMap;

/**
 * @author Ethan Zhang
 * @email ethan.zj@antfin.com
 */
public class NQueens {

    public void traverse(int n) {
        recursive(0, n);
    }

    private void recursive(int row, int col) {
        if (row >= col) {
            return;
        }

        for (int i = 0; i < col; i++) {
            System.out.println(row + "---" + i);
        }

        recursive(row + 1, col);
    }

    public static void main(String[] args) {
        new NQueens().traverse(4);

        HashMap[] map = new HashMap[9];
    }
}
