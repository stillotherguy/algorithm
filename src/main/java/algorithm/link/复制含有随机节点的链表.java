package algorithm.link;

import algorithm.utils.Node;
import com.google.common.collect.Maps;
import java.util.Map;

/**
 * @author Ethan Zhang
 * @date 2022/3/19
 */
public class 复制含有随机节点的链表 {

    public Node copy(Node head) {
        Map<Node, Node> cache = Maps.newHashMap();
        Node cur = head;
        while (cur != null) {
            cache.put(cur, new Node(cur.value));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            cache.get(cur).next = cache.get(cur.next);
            cache.get(cur).rand = cache.get(cur.rand);
            cur = cur.next;
        }

        return cache.get(head);
    }
}
