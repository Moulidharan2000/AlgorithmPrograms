package com.bridgelabz.algorithmprograms;

import java.util.Scanner;

public class MergeSort {
	
	public static void mergeSort(String[] words, int low, int high) {
		
		if(low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(words, low, mid);
			mergeSort(words, mid+1, high);
			merge(words, low, mid, high);
		}
	}
	
	public static void merge(String[] words, int low, int mid, int high) {
		
		int num1 = mid - low + 1;
		int num2 = high - mid;
		
		String[] left = new String[num1];
		String[] right = new String[num2];
		
		for(int i=0; i<num1; i++) {
			left[i] = words[low + i];
		}
		for(int j=0; j<num2; j++) {
			right[j] = words[mid + 1 + j];
		}
		int i=0, j=0, k=low;
		while(i<num1 && j<num2) {
			if(left[i].compareTo(right[j]) <= 0) {
				words[k] = left[i];
				i++;
			}
			else {
				words[k] = right[j];
				j++;
			}
			k++;
		}
		while(i<num1) {
			words[k] = left[i];
			i++;
			k++;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Size : ");
		int size = scan.nextInt();
		String[] words = new String[size];
		System.out.println("Enter the Words : ");
		for(int i=0; i<size; i++) {
			words[i] = scan.next();
		}
		mergeSort(words, 0, size-1);
		
		System.out.println("Sorted List : ");
		for(int i=0; i<size; i++) {
			System.out.print(words[i]+" ");
		}
	}
}
