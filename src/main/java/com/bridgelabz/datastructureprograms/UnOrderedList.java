package com.bridgelabz.datastructureprograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UnOrderedList {
	
	static class Node{
		String data;
		Node next;
		
		public Node(String data) {
			this.data = data;
			next = null;
		}
	}
	
	Node head;
	
	public void addNode(String data) {
		
		Node newNode = new Node(data);
		
		if(head == null)
			head = newNode;
		else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}		
	}
	
	public boolean searchNode(String word) {
		
		Node temp = head;
		while(temp != null) {
			if(temp.data.equals(word))
				return true;
			temp = temp.next;
		}
		return false;
	}
	
	public void deleteNode(String word) {
		
		Node temp = head;
		if(temp != null && temp.data.equals(word)) {
			head = temp.next;
			return;
		}
		while(temp != null && temp.next != null) {
			if(temp.next.data.equals(word)) {
				temp.next = temp.next.next;
				return;
			}
			temp = temp.next;
		}
	}
	
	public void writeFile(String filename) throws IOException {
		
		Node temp = head;
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		while(temp != null) {
			writer.write(temp.data+" ");
			temp = temp.next;
		}
		writer.close();
	}
	
	public void readFile(String filename) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line = reader.readLine();
		String[] words = line.split(" ");
		for(String word : words) {
			addNode(word);
		}
		reader.close();
	}

	public static void main(String[] args) throws IOException {
		
		UnOrderedList list = new UnOrderedList();
		list.readFile("D:\\JavaProjects\\Eclipse\\com.bridgelabz.algorithmprograms\\words.txt");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Word to Search : ");
		String word = scan.nextLine();
		
		if(list.searchNode(word)) {
			System.out.println("Word Found !!! and Removed.....");
			list.deleteNode(word);
		}
		else {
			System.out.println("Word Not Found !!! and Adding to List");
			list.addNode(word);
		}
		list.writeFile("words.txt");
	}
}
