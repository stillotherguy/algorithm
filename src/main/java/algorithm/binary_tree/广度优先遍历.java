package algorithm.binary_tree;

import algorithm.data_structure.BinaryTree;
import algorithm.utils.TreeNode;
import com.google.common.collect.Lists;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ethan Zhang
 * @date 2022/4/14
 */
public class 广度优先遍历 {

    public static void main(String[] args) {
        final TreeNode root = BinaryTree.create(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7));

        breadthFirstTraverse(root);
    }

    public static void breadthFirstTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                final TreeNode cur = queue.poll();

                System.out.println(cur.value);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
    }
}
