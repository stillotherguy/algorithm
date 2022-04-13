package algorithm.link;

import algorithm.utils.Node;

/**
 * @author Ethan Zhang
 * @date 2022/4/4
 */
public class 按照左右半区的方式组合链表 {

    public void relocate(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node mid = head;
        Node right = head.next;
        while (right.next != null && right.next.next != null) {
            mid = mid.next;
            right = right.next.next;
        }

        right = right.next;
        mid.next = null;
        merge(head, right);
    }

    private void merge(Node left, Node right) {
        Node next = null;
        while (left.next != null) {
            next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = next;
        }

        left.next = right;
    }
}
