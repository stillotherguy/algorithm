package algorithm.stack;

import java.util.Arrays;

/**
 * @author Ethan Zhang
 * @email ethan.zj@antfin.com
 */
public class MinStack {

    private Integer[] data;

    private Integer[] sortedData;

    private int currentIndex;

    /** initialize your data structure here. */
    public MinStack() {
        data = new Integer[8];
        sortedData = new Integer[8];
    }

    public void push(int x) {
        ensureCapacity();

        if (currentIndex < 0) {
            return;
        }

        data[currentIndex] = x;
        if (sortedData[currentIndex == 0 ? currentIndex : currentIndex - 1] == null) {
            sortedData[currentIndex] = x;
        } else {
            sortedData[currentIndex] = Math.min(x, sortedData[currentIndex == 0 ?currentIndex : currentIndex - 1]);
        }

        currentIndex++;
    }

    private void ensureCapacity() {
        if (currentIndex >= data.length) {
            data = Arrays.copyOf(data, data.length + 8);
            sortedData = Arrays.copyOf(sortedData, sortedData.length + 8);
        }
    }

    public void pop() {
        data[currentIndex - 1] = null;
        sortedData[currentIndex - 1] = null;
        currentIndex--;
    }

    public int top() {
        return data[currentIndex - 1];
    }

    public int getMin() {
        return sortedData[currentIndex - 1];
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);

        System.out.println(stack.getMin());

        stack.pop();

        System.out.println(stack.getMin());

        stack.pop();

        System.out.println(stack.getMin());

        stack.pop();

        System.out.println(stack.getMin());
    }
}
