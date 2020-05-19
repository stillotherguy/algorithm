package algorithm.tree;

import algorithm.tree.model.TreeNode;
import algorithm.tree.model.TreeNodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ethan Zhang
 * @email ethan.zj@antfin.com
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                temp.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(temp);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodes.generate2();
        System.out.println(new LevelOrder().levelOrder(root));
    }
}
