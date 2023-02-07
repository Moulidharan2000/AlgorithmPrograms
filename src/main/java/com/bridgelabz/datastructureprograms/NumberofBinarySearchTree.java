package com.bridgelabz.datastructureprograms;

import java.math.BigInteger;
import java.util.Scanner;

public class NumberofBinarySearchTree {
	
	static BigInteger[] dp = new BigInteger[1005];

	static BigInteger binomialCoeff(int n, int k) {
	
		BigInteger res = BigInteger.ONE;

		if (k > n - k)
			k = n - k;

		for (int i = 0; i < k; ++i) {
			res = res.multiply(BigInteger.valueOf(n - i));
			res = res.divide(BigInteger.valueOf(i + 1));
		}
		return res;
	}
	
	static BigInteger catalan(int n) {
		BigInteger c = binomialCoeff(2 * n, n);
		return c.divide(BigInteger.valueOf(n + 1));
	}
	
	public static void main(String[] args) {
		  
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		dp[0] = BigInteger.ONE;
		dp[1] = BigInteger.ONE;
		for (int i = 2; i <= 1000; i++) {
			dp[i] = BigInteger.ZERO;
			for (int j = 0; j < i; j++) {
				dp[i] = dp[i].add(dp[j].multiply(dp[i - j - 1]));
			}
		}
		while (t-- > 0) {
			int n = scan.nextInt();
			System.out.println(dp[n].mod(BigInteger.valueOf(1000000007)));
		}
	}
}

