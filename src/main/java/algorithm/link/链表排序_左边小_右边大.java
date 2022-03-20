package algorithm.link;

import static algorithm.utils.LinkUtils.generateList;
import static algorithm.utils.LinkUtils.print;
import static algorithm.utils.LinkUtils.swap;

import algorithm.utils.Node;

/**
 * 只是按照给定值，把小的放左边，大的放右边，进阶题目会对元素原来的顺序有要求
 *
 * @author Ethan Zhang
 * @date 2022/3/19
 */
public class 链表排序_左边小_右边大 {

    public static void main(String[] args) {
        Node head = generateList(10);
        print(head);

        head = listPartition(head, 5);

        print(head);
    }

    public static Node listPartition(Node node, int target) {
        if (node == null || node.next == null) {
            return node;
        }

        int size = size(node);
        Node[] arr = nodeArray(node, size);

        arrayPartition(arr, target);
        // link nodes together
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1].next = arr[i];
        }
        // remember tail.next should be null
        arr[size - 1].next = null;

        return arr[0];
    }

    private static void arrayPartition(Node[] arr, int target) {
        int small = -1;
        int big = arr.length;
        int index = 0;
        while (index != big) {
            if (arr[index].value < target) {
                swap(arr, ++small, index++);
            } else if (arr[index].value == target) {
                index++;
            } else {
                swap(arr, --big, index);
            }
        }
    }

    private static Node[] nodeArray(Node node, int size) {
        Node[] arr = new Node[size];
        Node cur = node;
        for (int i = 0; i < size; i++) {
            arr[i] = cur;
            cur = cur.next;
        }

        return arr;
    }

    private static int size(Node node) {
        int size = 0;
        Node cur = node;
        while (cur != null) {
            size++;
            cur = cur.next;
        }

        return size;
    }
}
