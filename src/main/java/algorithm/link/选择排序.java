package algorithm.link;

import algorithm.utils.Node;

/**
 * @author Ethan Zhang
 * @date 2022/4/4
 */
public class 选择排序 {

    public Node selectionSort(Node head) {
        // 排序列表得尾巴节点
        Node tail = null;
        Node small = null;
        Node cur = head;
        while (cur != null) {
            small = cur;
            Node smallPre = findSmallPre(cur);
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }

            // small值没变表示cur就是最小值
            cur = cur == small ? cur.next : cur;
            if (tail == null) {
                head = small;
            } else {
                tail.next = small;
            }

            tail = small;
        }

        return head;
    }

    private Node findSmallPre(Node head) {
        Node smallPre = null;
        Node pre = head;
        Node small = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.value < small.value) {
                smallPre = pre;
                small = cur;
            }

            pre = cur;
            cur = cur.next;
        }

        return smallPre;
    }
}
