package com.bridgelabz.datastructureprograms;

import java.util.LinkedList;
import java.util.Scanner;

public class PalindromeChecker {
	
	private LinkedList<Character> deque = new LinkedList<>();

	private void addCharacterToDeque(char c) {
		deque.addLast(c);
	}
	
	public boolean isPalindrome(String input) {
		for (int i = 0; i < input.length(); i++) {
			addCharacterToDeque(input.charAt(i));
		}

		while (deque.size() > 1) {
			if (deque.removeFirst() != deque.removeLast()) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String input = sc.nextLine();
		PalindromeChecker pc = new PalindromeChecker();
		boolean result = pc.isPalindrome(input);
		if (result) {
			System.out.println("The string is a palindrome");
		} else {
			System.out.println("The string is not a palindrome");
		}
	}
}
