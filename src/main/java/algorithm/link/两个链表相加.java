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
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }

        Queue<Node> queue = new LinkedList<>();
        Node cur = head1;
        while (cur != null) {
            queue.add(cur);
            cur = cur.next;
        }

        cur = head2;
        while (cur != null) {
            Node adder = queue.poll();
            if (adder != null) {

            }

            cur = cur.next;
        }
    }


}
