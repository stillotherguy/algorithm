package algorithm.link;

import algorithm.utils.TreeNode;
import com.google.common.collect.Lists;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ethan Zhang
 * @date 2022/4/3
 */
public class 将二叉搜索树转换成双向链表 {

    public TreeNode treeToLink(TreeNode root) {
        if (root == null) {
            return root;
        }

        LinkedList<TreeNode> list = Lists.newLinkedList();
        inOrderToList(root, list);

        root = list.poll();
        TreeNode pre = root;
        TreeNode cur = null;
        while (!list.isEmpty()) {
            cur = list.poll();

            cur.left = pre;
            pre.right = cur;

            pre = cur;
        }

        pre.right = null;

        return root;
    }

    private void inOrderToList(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }

        inOrderToList(root.left, list);
        list.add(root);
        inOrderToList(root.right, list);
    }
}
