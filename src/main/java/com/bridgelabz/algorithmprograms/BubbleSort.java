package com.bridgelabz.algorithmprograms;

import java.util.Scanner;

public class BubbleSort {
	
	public static void bubbleSort(int[] numbers, int size) {
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size - i - 1; j++) {
				if(numbers[j] > numbers[j+1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
		System.out.println("Sorted List :");
		for(int k=0; k < size; k++) {
			System.out.print(numbers[k]+" ");
		}
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Size of Array : ");
		int size = scan.nextInt();
		System.out.println("Enter the Numbers : ");
		int[] numbers = new int[size];
		
		for(int i=0; i<size; i++) {
			numbers[i] = scan.nextInt();
		}
		bubbleSort(numbers, size);
	}
}
