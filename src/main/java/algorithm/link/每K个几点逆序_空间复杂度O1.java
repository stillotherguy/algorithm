package algorithm.link;

import algorithm.utils.LinkUtils;
import algorithm.utils.Node;
import java.util.Stack;

/**
 * TODO 测试
 *
 * @author Ethan Zhang
 * @date 2022/3/27
 */
public class 每K个几点逆序_空间复杂度O1 {

    public static void main(String[] args) {
        Node head = LinkUtils.generateList(6);

        head = reverseKNode(head, 2);

        System.out.println();
    }

    public static Node reverseKNode(Node head, int k) {
        if (k < 2) {
            return head;
        }

        Node cur = head;
        Node prev = null;
        Node start = null;
        Node next = null;
        int cnt = 1;
        while (cur != null) {
            next = cur.next;
            if (cnt == k) {
                start = prev == null ? head : prev.next;
                head = prev == null ? cur : head;
                reverse(prev, start, cur, next);
                prev = start;
                cnt = 0;
            }

            cnt++;
            cur = next;
        }

        return head;
    }

    private static void reverse(Node left, Node start, Node end, Node right) {
        Node pre = null;
        Node cur = start.next;
        Node next = null;
        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        if (left != null) {
            left.next = end;
        }

        start.next = right;
    }
}
