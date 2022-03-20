package algorithm.link;

import algorithm.utils.Node;
import com.google.common.collect.Maps;
import java.util.Map;

/**
 * 额外
 *
 * @author Ethan Zhang
 * @date 2022/3/19
 */
public class 复制含有随机节点的链表_进阶 {

    public Node copy(Node head) {
        if (head == null) {
            return null;
        }

        // 设置链表为每个节点后紧跟着的是自己的副本节点
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }

        // 设置复制节点的rand指针
        cur = head;
        while (cur != null) {
            Node next = cur.next.next;
            Node curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;

            cur = next;
        }

        Node res = head.next;
        // 拆分链表
        cur = head;
        while (cur != null) {
            Node next = cur.next.next;
            Node curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }

       return res;
    }
}
