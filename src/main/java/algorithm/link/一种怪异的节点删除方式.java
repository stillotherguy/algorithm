package algorithm.link;

import algorithm.utils.Node;

/**
 * @author Ethan Zhang
 * @date 2022/4/4
 */
public class 一种怪异的节点删除方式 {

    public void remoteNodeWeird(Node node) {
        if (node == null) {
            return;
        }

        Node next = node.next;
        if (next == null) {
            throw new RuntimeException();
        }

        node.value = next.value;
        node.next = next.next;
    }
}
