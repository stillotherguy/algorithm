package algorithm.utils;

import com.google.common.base.Preconditions;
import java.util.Random;

/**
 * @author Ethan Zhang
 * @date 2022/3/19
 */
public class LinkUtils {

    public static void print(Node node) {
        while (node != null) {
            System.out.print(node.value + " " + (node.rand == null ? "" : node.rand.value));

            node = node.next;
        }

        System.out.print("========================");
    }

    public static void swap(Node[] array, int a, int b) {
        Node temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static Node generateList(int size) {
        int cnt = 0;
        Node head = null;
        Node cur = null;
        while (cnt < size) {
            if (cur == null) {
                head = cur = new Node(new Random().nextInt(10));
            } else {
                cur.next = new Node(new Random().nextInt(10));
                cur = cur.next;
            }
            cnt++;
        }

        return head;
    }

    public static Node generateListWithCycle(int startIndex, int size) {
        Preconditions.checkArgument(startIndex < size);

        int cnt = 0;
        Node head = null;
        Node cur = null;
        // 入环点
        Node start = null;
        while (cnt < size) {
            if (head == null) {
                head = cur = new Node(new Random().nextInt(10));
            } else {
                cur.next = new Node(new Random().nextInt(10));
                cur = cur.next;
            }

            if (cnt == startIndex) {
                start = cur;
            }

            cnt++;
        }

        cur.next = start;

        return head;
    }

    public static void main(String[] args) {
        final Node head = generateListWithCycle(1, 3);
        System.out.println(head);
    }
}
