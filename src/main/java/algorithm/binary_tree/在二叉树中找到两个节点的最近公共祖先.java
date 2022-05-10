package algorithm.binary_tree;

import algorithm.data_structure.BinaryTree;
import algorithm.utils.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.util.Assert;

/**
 * @author Ethan Zhang
 * @date 2022/5/9
 */
public class 在二叉树中找到两个节点的最近公共祖先 {

    public static void main(String[] args) {
        TreeNode head = BinaryTree.create(1, 2, 3, 4, 5, 6, 7);

        TreeNode parent = findParent1(head, new TreeNode(2), new TreeNode(4));

        Assert.isTrue(parent.equals(new TreeNode(2)));

        parent = findParent1(head, new TreeNode(2), new TreeNode(7));

        Assert.isTrue(parent.equals(new TreeNode(1)));
    }

    public static TreeNode findParent(TreeNode head, TreeNode o1, TreeNode o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }

        TreeNode left = findParent(head.left, o1, o2);
        TreeNode right = findParent(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }

        return left != null ? left : right;
    }

    public static TreeNode findParent1(TreeNode head, TreeNode o1, TreeNode o2) {
        ParentFinder finder = new ParentFinder(head);
        return finder.find(o1, o2);
    }

    private static class ParentFinder {
        private Map<TreeNode, TreeNode> cache;

        public ParentFinder(TreeNode head) {
            this.cache = new HashMap<>();
            if (head != null) {
                this.cache.put(head, null);
            }

            setMap(head);
        }

        private void setMap(TreeNode head) {
            if (head == null) {
                return;
            }

            if (head.left != null) {
                this.cache.put(head.left, head);
            }

            if (head.right != null) {
                this.cache.put(head.right, head);
            }

            setMap(head.left);
            setMap(head.right);
        }

        public TreeNode find(TreeNode o1, TreeNode o2) {
            Set<TreeNode> path = new HashSet<>();
            while (this.cache.containsKey(o1)) {
                    path.add(o1);
                    o1 = this.cache.get(o1);
            }

            while (!path.contains(o2)) {
                o2 = this.cache.get(o2);
            }

            return o2;
        }
    }
}
