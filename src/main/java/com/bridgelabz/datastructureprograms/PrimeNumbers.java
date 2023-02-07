package com.bridgelabz.datastructureprograms;

import java.util.ArrayList;

public class PrimeNumbers {
	
	private static final int UPPER_BOUND = 1000;
	private static final int RANGE = 100;
	private static final int MODULO = 1000000007;
	
	private static boolean isPrime(int n) {
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) 
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> primeNumbers = new ArrayList<>();
		for (int i = 0; i < UPPER_BOUND / RANGE; i++) {
			primeNumbers.add(new ArrayList<>());
		}
		for (int i = 2; i <= UPPER_BOUND; i++) {
			if (isPrime(i)) {
				int rangeIndex = (i - 1) / RANGE;
				primeNumbers.get(rangeIndex).add(i);
			}
		}
		System.out.println("Prime numbers in different ranges:");
		for (int i = 0; i < primeNumbers.size(); i++) {
			System.out.print((i * RANGE + 1) + "-" + (i + 1) * RANGE + ": ");
			for (int j = 0; j < primeNumbers.get(i).size(); j++) {
				System.out.print(primeNumbers.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}