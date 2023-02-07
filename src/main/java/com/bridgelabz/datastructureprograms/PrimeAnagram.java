package com.bridgelabz.datastructureprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeAnagram {
	
	public static boolean isPrime(int n) {
		if (n <= 1) return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) 
				return false;
		}
		return true;
	}
	
	public static boolean isAnagram(int a, int b) {
		
		char[] aArray = Integer.toString(a).toCharArray();
		char[] bArray = Integer.toString(b).toCharArray();
		Arrays.sort(aArray);
	    Arrays.sort(bArray);
	    return Arrays.equals(aArray, bArray);
	}

	public static void main(String[] args) {
		
		List<List<Integer>> anagrams = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			anagrams.add(new ArrayList<>());
		}
		for (int i = 2; i < 1000; i++) {
			if (isPrime(i)) {
				int range = i / 100;
				boolean added = false;
				for (int j = 2; j < 1000; j++) {
					if (isPrime(j) && isAnagram(i, j) && i != j) {
						anagrams.get(range).add(i);
						anagrams.get(range).add(j);
						added = true;
						break;
					}
				}
				if (!added) anagrams.get(range).add(i);
			}
		}
		System.out.println("Anagrams:");
		for (int i = 0; i < 10; i++) {
			System.out.println("Range " + (i * 100) + "-" + ((i + 1) * 100 - 1) + ": " + anagrams.get(i));
		}
		System.out.println("Not Anagrams:");
		for (int i = 0; i < 10; i++) {
			System.out.println("Range " + (i * 100) + "-" + ((i + 1) * 100 - 1) + ": " + notAnagrams.get(i));
		}
	}
}