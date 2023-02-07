package com.bridgelabz.datastructureprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
	
public class AddAnagramPrimeNumbers{
	
	public class Node {
		
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
		
	public class Stack {
		
		Node head;

		public Stack() {
			head = null;
		}

		public void push(int data) {
			if (head == null) {
				head = new Node(data);
			} else {
				Node newNode = new Node(data);
				newNode.next = head;
				head = newNode;
			}
		}

		public Integer pop() {
			if (head == null) {
				return null;
			} else {
				int popped = head.data;
				head = head.next;
				return popped;
			}
		}

		public boolean isEmpty() {
			return head == null;
		}
	}
		
	static boolean isPrime(int n) {
		
		if (n < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	static boolean isAnagram(String str1, String str2) {
     
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		return Arrays.equals(chars1, chars2);
	}
	
	static Stack addPrimeAnagramsToStack(int start, int end) {
		
		Stack stack = new Stack();
		for (int i = start; i <= end; i++) {
			if (isPrime(i)) {
				for (int j = i + 1; j <= end; j++) {
					if (isPrime(j) && isAnagram(String.valueOf(i), String.valueOf(j))) {
						stack.push(i);
						stack.push(j);
					}
				}
			}
		}
		return stack;
	}
	
		static void printStackInReverse(Stack stack) {
       
		List<Integer> list = new ArrayList<>();
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}
		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.print(list.get(i) + ", ");
			}
		}
		
	public static void main(String[] args) {
		
		 int start = 0;
		 int end = 1000;
		 Stack stack = addPrimeAnagramsToStack(start, end);
		 printStackInReverse(stack);
	}
}

