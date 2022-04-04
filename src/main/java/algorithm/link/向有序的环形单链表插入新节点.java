package algorithm.link;

import algorithm.utils.Node;

/**
 * @author Ethan Zhang
 * @date 2022/4/4
 */
public class 向有序的环形单链表插入新节点 {

    public Node insertNode(Node head, int num) {
        Node waitToInsert = new Node(num);
        if (head == null) {
            waitToInsert.next = waitToInsert;

            return waitToInsert;
        }

        Node pre = head;
        Node cur = head.next;
        while (cur != head) {
            if (pre.value <= num && num <= cur.value) {
                break;
            }

            pre = cur;
            cur = cur.next;
        }

        pre.next = waitToInsert;
        waitToInsert.next = cur;

        return waitToInsert.value > head.value ? head : waitToInsert;
    }
}
