package algorithm.binary_tree;

import algorithm.utils.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethan Zhang
 * @date 2022/4/19
 */
public class 找到二叉树中符合搜索二叉树条件的最大拓扑结构 {

    public int bstTopoSize1(TreeNode head) {
        if (head == null) {
            return 0;
        }

        int maxTopoSize = maxTopo(head, head);
        maxTopoSize = Math.max(bstTopoSize1(head.left), maxTopoSize);
        maxTopoSize = Math.max(bstTopoSize1(head.right), maxTopoSize);

        return maxTopoSize;
    }

    private int maxTopo(TreeNode h, TreeNode n) {
        if (h != null && n != null && isBSTNode(h, n, n.value)) {
            return maxTopo(h, n.left) + maxTopo(h, n.right) + 1;
        }

        return 0;
    }

    private boolean isBSTNode(TreeNode h, TreeNode n, int value) {
        if (h == null) {
            return false;
        }

        if (h == n) {
            return true;
        }

        return isBSTNode(value > h.value ? h.right : h.left, n, value);
    }

    public int bstTopoSize2(TreeNode head) {
        Map<TreeNode, Record> cache = new HashMap<>();

        return postOrder(head, cache);
    }

    private int postOrder(TreeNode head, Map<TreeNode, Record> cache) {
        if (head == null) {
            return 0;
        }

        int left = postOrder(head.left, cache);
        int right = postOrder(head.right, cache);

        modifyMap(head.left, head.value, cache, true);
        modifyMap(head.right, head.value, cache, false);

        Record lr = cache.get(head.left);
        Record rr = cache.get(head.right);

        int lbst = lr == null ? 0 : lr.leftCnt + lr.rightCnt + 1;
        int rbst = rr == null ? 0 : rr.leftCnt + rr.rightCnt + 1;
        cache.put(head, new Record(lbst, rbst));

        return Math.max(lbst + rbst + 1, Math.max(left, right));
    }

    private int modifyMap(TreeNode n, int v, Map<TreeNode, Record> cache, boolean s) {
        if (n == null || (!cache.containsKey(n))) {
            return 0;
        }

        Record r = cache.get(n);
        if ((s && n.value > v) || (!(s) && n.value < v)) {
            cache.remove(n);
            return r.leftCnt + r.rightCnt + 1;
        } else {
            int minus = modifyMap(s ? n.right : n.left, v, cache, s);
            if (s) {
                r.rightCnt = r.rightCnt - minus;
            } else {
                r.leftCnt = r.leftCnt - minus;
            }

            cache.put(n, r);

            return minus;
        }
    }

    private static class Record {
        public int leftCnt;

        public int rightCnt;

        private Record(int leftCnt, int rightCnt) {
            this.leftCnt = leftCnt;
            this.rightCnt = rightCnt;
        }
    }
}
