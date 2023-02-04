package com.bridgelabz.algorithmprograms;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {
	
	static ArrayList<String> permutations = new ArrayList<String>();
	
	static void Iterative(String str) {
		
		int n= str.length();
		boolean[] used = new boolean[n];
		StringBuilder sb = new StringBuilder();
		char[] charArray = str.toCharArray();
		permutations.clear();
		
		for(int i=0; i<n; i++) {
			used[i] = true;
			sb.append(charArray[i]);
			Iterative(charArray, sb, used, n);
			used[i] = false;
			sb.setLength(sb.length()-1);
		}
	}
	
	static void Iterative(char[] charArray, StringBuilder sb, boolean[] used, int n) {
		
		if(sb.length() == n) {
			permutations.add(sb.toString());
			return;
		}
		for(int i=0; i<n; i++) {
			if(!used[i]) {
				used[i] = true;
				sb.append(charArray[i]);
				Iterative(charArray, sb, used, n);
				used[i] = false;
				sb.setLength(sb.length() - 1);
			}
		}
	}
	
	static ArrayList<String> getPermutationsRercursively(String str){
		
		if(str.length() == 0) {
			ArrayList<String> empty = new ArrayList<String>();
			empty.add("");
			return empty;
		}
		
		ArrayList<String> result = new ArrayList<String>();
		for(int i=0; i<str.length(); i++) {
			String prefix = str.substring(0, i);
			String suffix = str.substring(i+1);
			ArrayList<String> temp = getPermutationsRercursively(prefix + suffix);
			for(String s : temp) {
				result.add(str.charAt(i)+s);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		String str = "abc";
		Iterative(str);
		ArrayList<String> result1 = permutations;
		ArrayList<String> result2 = getPermutationsRercursively(str);
		
		boolean areEqual = Arrays.equals(result1.toArray(), result2.toArray());
		System.out.println("Arrays are Equal : "+areEqual);
	}
}
