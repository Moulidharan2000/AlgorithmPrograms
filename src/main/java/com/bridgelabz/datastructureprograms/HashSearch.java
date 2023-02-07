package com.bridgelabz.datastructureprograms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HashSearch {
	
	static Map<Integer, LinkedList<Integer>> map = new HashMap<>();
    static final int SLOTS = 11;

    static {
    	for (int i = 0; i < SLOTS; i++) {
        	map.put(i, new LinkedList<>());
    	}
    }

    static int hash(int num) {
        return num % SLOTS;
    }

    static boolean search(int num) {
        int slot = hash(num);
        LinkedList<Integer> list = map.get(slot);
        if (list.contains(num)) {
            list.remove(num);
            return true;
        } else {
            list.add(num);
            return false;
        }
    }

    static void readFromFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            int num = Integer.parseInt(line);
            int slot = hash(num);
            map.get(slot).add(num);
        }
        br.close();
    }

    static void writeToFile(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        for (int i = 0; i < SLOTS; i++) {
            LinkedList<Integer> list = map.get(i);
            for (int num : list) {
                writer.write(num + "\n");
            }
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        
    	readFromFile("numbers.txt");
        int num = 33;
        boolean found = search(num);
        System.out.println("Number " + num + (found ? " found and removed" : " not found and added"));
        writeToFile("result.txt");
    }
}