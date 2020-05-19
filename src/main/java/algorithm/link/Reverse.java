package algorithm.link;

import algorithm.link.model.Node;

/**
 * @author Ethan Zhang
 * @email ethan.zj@antfin.com
 */
public class Reverse {

    public void reverse(Node header) {
        if (header == null || header.next == null) {
            return;
        }

        Node current = header.next;
        Node next = current.next;
        //while ()
    }
}
