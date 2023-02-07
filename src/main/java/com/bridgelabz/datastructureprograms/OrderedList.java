package com.bridgelabz.datastructureprograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OrderedList {
	
	class Node {
		
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	Node head;

	public void addNode(int data) {

		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
		} else if (head.data > data) {
			newNode.next = head;
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null && temp.next.data < data) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}

	public boolean searchNode(int number) {
	
		Node temp = head;
		while (temp != null) {
			if (temp.data == number) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public void deleteNode(int number) {
	
		Node temp = head;
		if (temp != null && temp.data == number) {
	    	head = temp.next;
	    	return;
		}
		
		while (temp != null && temp.next != null) {
			if (temp.next.data == number) {
				temp.next = temp.next.next;
				return;
			}
			temp = temp.next;
		}
	}

	public void writeToFile(String filename) throws IOException {
		
		Node temp = head;
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		while (temp != null) {
	      writer.write(temp.data + " ");
	      temp = temp.next;
		}
		writer.close();
	}
	
	public void readFromFile(String filename) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line = reader.readLine();
		String[] numbers = line.split(" ");
		for (String number : numbers) {
			addNode(Integer.parseInt(number));
		}
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
	
		OrderedList list = new OrderedList();
		list.readFromFile("D:\\JavaProjects\\Eclipse\\com.bridgelabz.algorithmprograms\\numbers.txt");

	    Scanner scan = new Scanner(System.in);
	    System.out.print("Enter a number to search: ");
	    int number = scan.nextInt();

	    if (list.searchNode(number)) {
	      System.out.println("Number found and Deleting from list !!!");
	      list.deleteNode(number);
	    } else {
	      System.out.println("Number not found and Adding to list !!!");
	      list.addNode(number);
	    }

	    list.writeToFile("numbers.txt");
	  }
	}
