package com.bridgelabz.datastructureprograms;

import java.util.Stack;

public class SimpleBalancedParantheses {

	public static boolean isBalanced(String expression) {
	  
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			char current = expression.charAt(i);
			if (current == '(') {
				stack.push(current);
			} else if (current == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		
	    String expression = "(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3)";
	    System.out.println("The expression is balanced: " + isBalanced(expression));
	}
}
