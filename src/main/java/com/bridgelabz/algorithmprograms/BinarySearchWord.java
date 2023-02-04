package com.bridgelabz.algorithmprograms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchWord {
	
	static String[] readWordsFromFile(String fileName) {
		
		String content = "";
		try {
			Scanner scan = new Scanner(new File(fileName));
			while(scan.hasNextLine()) {
				content += scan.nextLine()+",";
			}
			scan.close();
		}catch(FileNotFoundException e) {
			System.out.println("File Not Found : "+fileName);
		}
		return content.split(",");
	}
	
	static int binarySearch(String[] words, String searchWord) {
		
		int left = 0;
		int right = words.length -1;
		while(left <= right) {
			int mid = (left+right)/2;
			int compareResult = words[mid].compareTo(searchWord);
			if(compareResult == 0)
				return mid;
			else if(compareResult == 0)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		String[] words = readWordsFromFile("D:\\JavaProjects\\Eclipse\\com.bridgelabz.algorithmprograms\\words.txt");
		Arrays.sort(words);
		
		Scanner read = new Scanner(System.in);
		System.out.print("Enter the Word to Search : ");
		String searchWord = read.nextLine();
		
		int index = binarySearch(words, searchWord);
		if(index != -1)
			System.out.println("Word found at Index : "+index);
		else
			System.out.println("Word not found in the List");
	}
}
