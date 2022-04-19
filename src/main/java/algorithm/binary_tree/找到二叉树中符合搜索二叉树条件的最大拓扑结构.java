package algorithm.binary_tree;

import algorithm.utils.TreeNode;

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
}
