package algorithm.utils;

/**
 * @author Ethan Zhang
 * @date 2022/3/19
 */
public class Node {

    public int value;

    public Node next;

    public Node rand;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
               "value=" + value +
               '}';
    }
}
