package com.bridgelabz.algorithmprograms;

import java.util.Scanner;

public class InsertionSort {
	
	public static void insertionSort(String[] words, int size) {
		
		for(int j=1; j<size; j++) {
			String key = words[j];
			int k = j-1;
			while(k >= 0 && words[k].compareTo(key) > 0) {
				words[k+1] = words[k];
				k = k-1;
			}
			words[k+1] = key;
		}
		System.out.println("Sorted List : ");
		for(int k=0; k<size; k++) {
			System.out.print(words[k]+" ");
		}
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int size = scan.nextInt();
		String[] words = new String[size];
		System.out.println("Enter the Words : ");
		
		for(int i=0; i<size; i++) {
			words[i] = scan.next();
		}
		insertionSort(words, size);
	}
}
