package com.bridgelabz.datastructureprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeAnagramsQueue {
	
	class Node {
	    int data;
	    Node next;

	    public Node(int data) {
	        this.data = data;
	        this.next = null;
	    }
	}
	
	class Queue {
	    Node head;
	    Node tail;

	    public Queue() {
	        head = null;
	        tail = null;
	    }

	    public void enqueue(int data) {
	        if (head == null) {
	            head = new Node(data);
	            tail = head;
	        } else {
	            tail.next = new Node(data);
	            tail = tail.next;
	        }
	    }

	    public Integer dequeue() {
	        if (head == null) {
	            return null;
	        } else {
	            int dequeued = head.data;
	            head = head.next;
	            return dequeued;
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
	
	 static Queue addPrimeAnagramsToQueue(int start, int end) {
		 
		 Queue queue = new Queue();
		 for (int i = start; i <= end; i++) {
			 if (isPrime(i)) {
				 for (int j = i + 1; j <= end; j++) {
					 if (isPrime(j) && isAnagram(String.valueOf(i), String.valueOf(j))) {
						 queue.enqueue(i);
						 queue.enqueue(j);
					 }
				 }
			 }
		 }
		 return queue;
	 }

	 static void printQueue(Queue queue) {
	       
		 List<Integer> list = new ArrayList<>();
		 while (!queue.isEmpty()) {
			 list.add(queue.dequeue());
		 }
		 for (int i = 0; i < list.size(); i++) {
			 System.out.print(list.get(i) + ", ");
		 }
	 }

	 public static void main(String[] args) {
		 int start = 0;
		 int end = 1000;
		 Queue queue = addPrimeAnagramsToQueue(start, end);
		 printQueue(queue);
	 }
}

