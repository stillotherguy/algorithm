package algorithm;

import algorithm.tree.model.TreeNode;
import algorithm.tree.model.TreeNodes;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Ethan Zhang
 * @email ethan.zj@antfin.com
 */
public class Solution {

    Deque<TreeNode> Q = new LinkedList<>();

    Deque<TreeNode> P = new LinkedList<>();

    TreeNode currentP = null;

    TreeNode currentQ = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        currentP = p;
        currentQ = q;
        recursive(root);

        if (P.contains(q)) {
            return q;
        } else if (Q.contains(p)) {
            return p;
        }

        TreeNode result = null;
        while (!Q.isEmpty() && !P.isEmpty()) {
            TreeNode temp = Q.pollFirst();
            if (temp == P.pollFirst()) {
                result = temp;
            }
        }

        return result;
    }

    private void recursive(TreeNode root) {
        if (root == null) {
            return;
        }

        recursive(root.left);
        recursive(root.right);

        if (root.left == currentP || root.right == currentP) {
            P.add(root);
            currentP = root;
        }

        if (root.left == currentQ || root.right == currentQ) {
            Q.add(root);
            currentQ = root;
        }
    }

    public static void main(String[] args) {
        TreeNode[] root = TreeNodes.generate1();

        new Solution().lowestCommonAncestor(root[0], root[1], root[2]);
    }
}
