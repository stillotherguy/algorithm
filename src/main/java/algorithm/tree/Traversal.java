package algorithm.tree;

import algorithm.tree.model.TreeNode;
import algorithm.tree.model.TreeNodes;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ethan Zhang
 * @email ethan.zj@antfin.com
 */
public class Traversal {

    /**
     * 广度优先遍历
     */
    public void BFS(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(treeNode);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }

            // handle current node
            System.out.println(node.getVal());

            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }

            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }
    }

    /**
     * 深度优先遍历
     */
    public void DFS(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        System.out.println(treeNode.getVal());

        DFS(treeNode.getLeft());
        DFS(treeNode.getRight());
    }

    public void preorder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        System.out.println(treeNode.getVal());
        inorder(treeNode.getLeft());
        inorder(treeNode.getRight());
    }

    public void inorder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        inorder(treeNode.getLeft());
        System.out.println(treeNode.getVal());
        inorder(treeNode.getRight());
    }

    public void postorder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        inorder(treeNode.getLeft());
        inorder(treeNode.getRight());
        System.out.println(treeNode.getVal());
    }

    /**
     *     1
     *   2   3
     * 4        5
     *       6
     */
    public static void main(String[] args) {
        TreeNode node = TreeNodes.generate();

        new Traversal().BFS(node);
        System.out.println("============");
        new Traversal().DFS(node);
        System.out.println("============");
        new Traversal().preorder(node);
        System.out.println("============");
        new Traversal().inorder(node);
        System.out.println("============");
        new Traversal().postorder(node);
    }
}
