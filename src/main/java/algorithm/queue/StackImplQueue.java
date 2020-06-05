package algorithm.queue;

import java.util.Stack;

public class StackImplQueue {

	private Stack<Integer> s1;

	private Stack<Integer> s2;

	private Integer front;

	/** Initialize your data structure here. */
	public StackImplQueue() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		if (s1.isEmpty()) {
			front = x;
		}

		s1.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}

		return s2.pop();
	}

	/** Get the front element. */
	public int peek() {
		return !s2.isEmpty() ? s2.peek() : front;
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return s1.isEmpty() && s2.isEmpty();
	}
}
