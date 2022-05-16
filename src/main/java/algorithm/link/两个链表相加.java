package algorithm.link;

import algorithm.utils.Node;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ethan Zhang
 * @date 2022/5/6
 */
public class 两个链表相加 {

    public Node add(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        int adder = 0;
        Node dummy = new Node(0);
        Node head = dummy;
        while (head1 != null || head2 != null || adder != 0) {
            int val1 = head1 == null ? 0 : head1.value;
            int val2 = head2 == null ? 0 : head2.value;

            int sum = val1 + val2 + adder;
            head.next = new Node(sum % 10);
            head = head.next;

            adder = sum / 10;

            if (head1 != null) {
                head1 = head1.next;
            }

            if (head2 != null) {
                head2 = head2.next;
            }
        }

        return dummy.next;
    }


}
