package algorithm.array;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/submissions/
 */
public class ClimbStairs {

	public int climbStairs(int n) {
		int a = 0;
		int b = 0;
		int r = 1;
		for (int i = 0; i < n; ++i) {
			a = b;
			b = r;
			r = a + b;
		}

		return r;
	}
}
