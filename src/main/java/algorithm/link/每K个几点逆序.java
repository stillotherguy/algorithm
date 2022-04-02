package algorithm.link;

import algorithm.utils.Node;
import java.util.Stack;

/**
 * TODO 测试
 *
 * @author Ethan Zhang
 * @date 2022/3/27
 */
public class 每K个几点逆序 {

    public Node reverseKNode(Node head, int k) {
        if (k < 2) {
            return head;
        }

        Stack<Node> stack = new Stack<>();
        Node newHead = head;
        Node pre = null;
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            stack.push(cur);
            if (stack.size() == k) {
                pre = reverse(stack, pre, next);
                newHead = newHead == head ? cur : newHead;
            }
            cur = next;
        }

        return newHead;
    }

    private Node reverse(Stack<Node> stack, Node left, Node right) {
        Node cur = stack.pop();
        if (left != null) {
            left.next = cur;
        }

        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }

        cur.next = right;
        return cur;
    }
}
