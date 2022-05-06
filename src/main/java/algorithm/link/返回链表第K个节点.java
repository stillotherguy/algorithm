package algorithm.link;

import algorithm.utils.Node;

/**
 * @author Ethan Zhang
 * @date 2022/5/6
 */
public class 返回链表第K个节点 {

    public static Node k(Node head, int k) {
        if (head == null || k < 1) {
            return null;
        }

        Node slow, fast;
        slow = fast = head;
        while (k > 0) {
            k--;
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
