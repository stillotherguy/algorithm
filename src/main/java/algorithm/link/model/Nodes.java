package algorithm.link.model;

/**
 * @author Ethan Zhang
 * @email ethan.zj@antfin.com
 */
public class Nodes {

    public Node list() {
        Node header = new Node();
        header.val = 1;

        Node n1 = new Node();
        n1.val = 2;

        header.next = n1;

        Node n2 = new Node();
        n2.val = 3;

        n1.next = n2;

        Node n3 = new Node();
        n3.val = 4;

        n2.next = n3;

        Node n4 = new Node();
        n4.val = 5;

        n3.next = n4;

        Node n5 = new Node();
        n5.val = 6;

        n4.next = n5;

        return header;
    }
}
