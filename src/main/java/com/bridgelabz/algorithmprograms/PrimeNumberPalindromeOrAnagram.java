package com.bridgelabz.algorithmprograms;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeNumberPalindromeOrAnagram {

	public static boolean isPrime(int num) {
		if(num <= 1)
			return false;
		for(int i=2; i<num; i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}
	
	public static boolean isAnagram(String first, String second) {
	    
		char[] firstArray = first.toCharArray();
	    char[] secondArray = second.toCharArray();
	    Arrays.sort(firstArray);
	    Arrays.sort(secondArray);
	    return Arrays.equals(firstArray, secondArray);
	  }
	
	public static boolean isPalindrome(int num) {
	   
		int originalNum = num;
	    int reverse = 0;
	    while (num > 0) {
	      int lastDigit = num % 10;
	      reverse = (reverse * 10) + lastDigit;
	      num = num / 10;
	    }
	    return originalNum == reverse;
	  }
	
	public static void main(String[] args) {
		
		ArrayList<Integer> primeNumbers = new ArrayList<>();
		for (int i = 0; i <= 1000; i++) {
			if (isPrime(i))
				primeNumbers.add(i);
		}
		System.out.println("Prime numbers From 0 to 1000 that are both anagrams and palindromes are:");
		for (int i = 0; i < primeNumbers.size(); i++) {
			for (int j = i + 1; j < primeNumbers.size(); j++) {
				if (isAnagram(String.valueOf(primeNumbers.get(i)), String.valueOf(primeNumbers.get(j)))
						&& isPalindrome(primeNumbers.get(i))
						&& isPalindrome(primeNumbers.get(j)))
					System.out.println(primeNumbers.get(i) + " " + primeNumbers.get(j));
			}
		}
	}
}