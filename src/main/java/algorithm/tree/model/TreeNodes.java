package algorithm.tree.model;

/**
 * @author Ethan Zhang
 * @email ethan.zj@antfin.com
 */
public class TreeNodes {

    public static TreeNode generate() {
        TreeNode node1 = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.setLeft(node2);
        node1.setRight(node3);

        TreeNode node4 = new TreeNode(4);
        node2.setLeft(node4);

        TreeNode node5 = new TreeNode(5);
        node3.setRight(node5);

        TreeNode node6 = new TreeNode(6);
        node5.setLeft(node6);

        return node1;
    }

    public static TreeNode[] generate1() {
        TreeNode node1 = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.setLeft(node2);
        node1.setRight(node3);

        TreeNode node4 = new TreeNode(4);
        node2.setLeft(node4);

        TreeNode node5 = new TreeNode(5);
        node3.setRight(node5);

        TreeNode node6 = new TreeNode(6);
        node5.setLeft(node6);

        return new TreeNode[] {node1, node5, node6};
    }

    public static TreeNode generate2() {
        TreeNode node1 = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.setLeft(node2);
        node1.setRight(node3);

        TreeNode node4 = new TreeNode(4);
        node2.setLeft(node4);

        TreeNode node5 = new TreeNode(5);
        node2.setRight(node5);

        return node1;
    }
}