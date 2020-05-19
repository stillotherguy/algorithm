package algorithm.str;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ethan Zhang
 * @email ethan.zj@antfin.com
 */
public class ParanthesisGenerator {

    public List<String> dfs(int n) {
        List<String> result = new ArrayList<String>(2 * n);

        dfsImpl("", result, n, n);

        return result;
    }

    private void dfsImpl(String str, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(str);

            return;
        }

        // 剪枝
        if (right < left) {
            return;
        }

        if (left > 0) {
            dfsImpl(str + "(", result, left - 1, right);
        }

        if (right > 0) {
            dfsImpl(str + ")", result, left, right - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new ParanthesisGenerator().dfs(3));
    }
}
