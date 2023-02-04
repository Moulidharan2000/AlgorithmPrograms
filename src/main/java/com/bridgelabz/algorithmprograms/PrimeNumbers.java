package com.bridgelabz.algorithmprograms;

public class PrimeNumbers {
	
	public static boolean isPrime(int num) {
		if(num <= 1)
			return false;
		for(int i=2; i<num; i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		
		System.out.println("Prime Numbers from 0 to 1000");
		for(int i=0; i<=1000; i++) {
			if(isPrime(i))
				System.out.print(i+" ");
		}
	}
}
