package algorithm.link;

import algorithm.utils.LinkUtils;
import algorithm.utils.Node;

/**
 * @author Ethan Zhang
 * @date 2022/3/20
 */
public class 有环链表入环节点 {

    public static void main(String[] args) {
        Node head = LinkUtils.generateListWithCycle(1, 5);

        Node start = getLoopNode(head);

        System.out.println();
    }

    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow, fast;
        slow = head.next;
        fast = head.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                // 走到了链表末尾，无环
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static Node getLoopNodeII(Node head) {
        Node slow, fast, encounter;
        slow = fast = head;
        encounter = null;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                encounter = slow;
                break;
            }
        }

        if (encounter == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
