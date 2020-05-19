package algorithm.tree;

import algorithm.tree.model.TreeNode;
import algorithm.tree.model.TreeNodes;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ethan Zhang
 * @email ethan.zj@antfin.com
 */
public class Depth {

    private int min;

    private int max;

    public void DFS(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        DFSImpl(treeNode, 1);
    }

    private void DFSImpl(TreeNode treeNode, int i) {
        if (treeNode.isLeaf()) {
            if (min == 0 || max == 0) {
                if (min == 0) {
                    min = i;
                }

                if (max == 0) {
                    max = i;
                }
            } else {
                if (i < min) {
                    min = i;
                }

                if (i > max) {
                    max = i;
                }
            }
        }


        i++;

        if (treeNode.getLeft() != null) {
            DFSImpl(treeNode.getLeft(), i);
        }

        if (treeNode.getRight() != null) {
            DFSImpl(treeNode.getRight(), i);
        }
    }

    public void BFS(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(treeNode);

        int currentLevel = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.isLeaf()) {
                    if (min == 0) {
                        min = currentLevel;
                    }

                    max = currentLevel;
                }

                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }

                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }

            currentLevel++;
        }
    }

    public static void main(String[] args) {
        TreeNode node = TreeNodes.generate();

        Depth depth = new Depth();
        depth.DFS(node);

        System.out.println(depth.min + "----" + depth.max);

        depth = new Depth();
        depth.BFS(node);

        System.out.println(depth.min + "----" + depth.max);
    }
}
