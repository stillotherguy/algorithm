package algorithm.link;

import algorithm.utils.Node;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/**
 * @author Ethan Zhang
 * @date 2022/4/2
 */
public class 删除重复节点 {

    // 使用HashMap
    public static void removeDup1(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Set<Integer> cache = Sets.newHashSet();
        cache.add(head.value);

        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (cache.contains(cur.value)) {
                pre.next = cur.next;
            } else {
                cache.add(cur.value);
                pre = cur;
            }

            cur = cur.next;
        }
    }

    // 时间复杂度O(N^2) 空间复杂度O(1) 类似选择排序
    public static void removeDup2(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node cur = head;
        while (cur != null) {
            Node pre = cur;
            Node next = cur.next;
            while (next != null) {
                if (cur.value == next.value) {
                    pre.next = next.next;
                } else {
                    pre = next;
                }

                next = next.next;
            }

            cur = cur.next;
        }
    }
}
