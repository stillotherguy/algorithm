package algorithm.link;

import algorithm.utils.Node;

/**
 * TODO 待测试
 *
 * @author Ethan Zhang
 * @date 2022/3/19
 */
public class 链表归并排序 {

    public Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 快慢指针找到中间节点
        Node slow, fast;
        slow = fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow.next;
        // 切断链表
        slow.next = null;

        Node left = sort(head);
        Node right = sort(mid);

        return merge(left, right);
    }

    private Node merge(Node left, Node right) {
        Node head = new Node(0);
        Node temp = head;
        while (left != null && right != null) {
            if (left.value < right.value) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }

            temp = temp.next;
        }

        if (left != null) {
            temp.next = left;
        } else {
            temp.next = right;
        }

        return head.next;
    }
}
