package algorithm.link;

import algorithm.link.model.Node;

/**
 * @author Ethan Zhang
 * @email ethan.zj@antfin.com
 */
public class Reverse {

	public void reverse(Node head) {
		Node cur = null;
		Node prev = head;
		while (prev != null) {
            Node next = head.next;
            prev.next = cur;

            cur = prev;
            prev = next;
		}
	}

	public static void main(String[] args) {
		System.out.println("()".substring(2, 2).length());
	}
}
