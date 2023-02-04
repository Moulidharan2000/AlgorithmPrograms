package com.bridgelabz.algorithmprograms;

import java.util.Scanner;

public class FindYourNumber {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the value of N: ");
		int n = scan.nextInt();
		int low = 0, high = n - 1;
		int mid = (low + high) / 2;
		while (low <= high) {
			System.out.println("Is your number between " + low + " and " + high + " (inclusive)?");
			System.out.print("Enter true or false: ");
			boolean isBetween = scan.nextBoolean();
			if (isBetween) {
				low = low;
				high = mid;
				mid = (low + high) / 2;
			} else {
				low = mid + 1;
				high = high;
				mid = (low + high) / 2;
			}
		}
		System.out.println("The number you thought of is: " + low);
	}
}