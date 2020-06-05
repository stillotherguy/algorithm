package algorithm.heap;

import java.util.PriorityQueue;

public class KthLargest {

	final PriorityQueue<Integer> queue;

	final int k;

	public KthLargest(int[] a, int k) {
		this.queue = new PriorityQueue<>(k);
		this.k = k;
		for (int temp : a) {
			this.queue.add(temp);
		}
	}

	public int add(int x) {
		if (this.queue.size() < k) {
			this.queue.add(x);
		} else if (x > this.queue.peek()) {
			this.queue.poll();
			this.queue.add(x);
		}

		return queue.peek();
	}

	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue<>(3);


		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);

		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}
}
