package com.bridgelabz.algorithmprograms;

import java.util.Arrays;
import java.util.Scanner;

public class TaskScheduling {

	static class Task implements Comparable<Task> {
		int deadline;
		int minutes;

		public Task(int deadline, int minutes) {
			this.deadline = deadline;
			this.minutes = minutes;
		}
		
		@Override
		public int compareTo(Task o) {
			return this.deadline - o.deadline;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of tasks: ");
		int n = input.nextInt();
		Task[] tasks = new Task[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Enter the deadline and minutes for task " + (i + 1) + ": ");
			int deadline = input.nextInt();
			int minutes = input.nextInt();
			tasks[i] = new Task(deadline, minutes);
		}
		Arrays.sort(tasks);
		int time = 0;
		int maxOver = 0;
		for (int i = 0; i < n; i++) {
			time += tasks[i].minutes;
			int over = time - tasks[i].deadline;
			if (over > maxOver) {
				maxOver = over;
			}
		}
		System.out.println("The maximum time to complete the Task is: " + maxOver);
	}
}
