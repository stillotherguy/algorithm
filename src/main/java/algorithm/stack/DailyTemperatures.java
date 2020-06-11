package algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/submissions/
 */
public class DailyTemperatures {

	public int[] dailyTemperatures(int[] T) {
		int[] ans = new int[T.length];
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < T.length; i++) {
			while (!deque.isEmpty() && T[i] > T[deque.peek()]) {
				int prevIndex = deque.pop();
				ans[prevIndex] = i - prevIndex;
			}

			deque.push(i);
		}

		return ans;
	}
}
