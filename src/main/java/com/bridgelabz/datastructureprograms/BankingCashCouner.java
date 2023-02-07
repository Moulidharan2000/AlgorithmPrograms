package com.bridgelabz.datastructureprograms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BankingCashCouner {
	
	static int balance = 0;

	public static void deposit(int amount) {
		
		balance += amount;
		System.out.println("Deposited " + amount + ". Current balance: " + balance);
	}

	public static void withdraw(int amount) {
		
		if (balance < amount) {
			System.out.println("Insufficient balance. Current balance: " + balance);
			return;
		}
		balance -= amount;
		System.out.println("Withdrew " + amount + ". Current balance: " + balance);
	}

	public static void main(String[] args) {
	   
		Queue<Integer> depositQueue = new LinkedList<>();
		Queue<Integer> withdrawQueue = new LinkedList<>();
		Scanner scan = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Enter your choice: 1. Deposit 2. Withdraw 3. Exit");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter amount to deposit: ");
				int depositAmount = scan.nextInt();
				depositQueue.add(depositAmount);
				break;
			case 2:
				System.out.println("Enter amount to withdraw: ");
				int withdrawAmount = scan.nextInt();
				withdrawQueue.add(withdrawAmount);
				break;
			case 3:
				System.out.println("Exiting");
				break;
	        default:
	        	System.out.println("Invalid choice");
			}
			while (!depositQueue.isEmpty()) {
				deposit(depositQueue.remove());
			}
			while (!withdrawQueue.isEmpty()) {
				withdraw(withdrawQueue.remove());
			}
		} while (choice != 3);
		scan.close();
	}
}
