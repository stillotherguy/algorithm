package algorithm.str;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValidParanthesis {

	private Map<Character, Character> params = new HashMap<>();

	{
		this.params.put(')', '(');
		this.params.put(']', '[');
		this.params.put('}', '{');
	}

	public boolean isValid(String s) {
		if (s == null) {
			return false;
		}

		if ("".equals(s)) {
			return true;
		}

		Stack<Character> stack = new Stack<>();
		for (Character c : s.toCharArray()) {
			if (this.params.containsKey(c)) {
				if (stack.pop() != this.params.get(c) || stack.isEmpty()) {
					return false;
				}

			} else {
				stack.push(c);
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(new IsValidParanthesis().isValid("["));
	}
}
