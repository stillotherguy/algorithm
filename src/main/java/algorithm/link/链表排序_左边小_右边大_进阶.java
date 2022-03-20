package algorithm.link;

import static algorithm.utils.LinkUtils.generateList;
import static algorithm.utils.LinkUtils.print;
import static algorithm.utils.LinkUtils.swap;

import algorithm.utils.Node;

/**
 * 只是按照给定值，把小的放左边，大的放右边，空间复杂度为1，并且元素按链表里的顺序摆放
 *
 * @author Ethan Zhang
 * @date 2022/3/19
 */
public class 链表排序_左边小_右边大_进阶 {

    public static void main(String[] args) {
        Node head = generateList(5);
        print(head);

        head = listPartition(head, 5);

        print(head);
    }

    public static Node listPartition(Node node, int target) {
        if (node == null || node.next == null) {
            return node;
        }

        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node head = node;
        while (head != null) {
            Node next = head.next;
            head.next = null;
            if (head.value < target) {
                if (sH == null) {
                    sH = sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == target) {
                if (eH == null) {
                    eH = eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }

            head = next;
        }

        // connect three list: any of them could be null
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }

        if (eT != null) {
            eT.next = bH;
        }

        return sH != null ? sH : eH != null ? eH : bH;
    }
}
