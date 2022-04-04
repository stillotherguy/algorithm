package algorithm.link;

import algorithm.utils.Node;
import java.util.Stack;

/**
 * @author Ethan Zhang
 * @date 2022/4/2
 */
public class 删除指定值的节点 {

    public Node removeNode1(Node head, int value) {
        if (head == null) {
            return null;
        }

        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            if (cur.value == value) {
                continue;
            }

            stack.push(cur);
            cur = cur.next;
        }

        Node pre = null;
        while (!stack.isEmpty()) {
            stack.peek().next = pre;
            pre = stack.pop();
        }

        return pre;
    }

    public Node removeNode2(Node head, int value) {
        if (head == null) {
            return null;
        }

        Node newHead = null;
        while (head != null) {
            if (head.value != value) {
                newHead = head;
                break;
            }

            head = head.next;
        }

        Node pre = newHead;
        Node cur = newHead;
        while (cur != null) {
            Node next = cur.next;
            if (cur.value == value) {
                pre.next = next;
            } else {
                pre = cur;
            }

            cur = cur.next;
        }

        return pre;
    }
}
