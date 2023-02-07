package com.bridgelabz.datastructureprograms;

import java.util.Scanner;

public class MonthCalendar {
	
	static int year;
    static int month;
    static int day;
    static int daysInMonth;
    static int startingDayOfWeek;
    static int[][] calendar;

    public static void main(String[] args) {
       
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter the year: ");
    	year = sc.nextInt();
    	System.out.print("Enter the month (1-12): ");
    	month = sc.nextInt();

    	switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInMonth = 31;
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    daysInMonth = 29;
                } else {
                    daysInMonth = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = 30;
                break;
        }

     	int y = year - (14 - month) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        startingDayOfWeek = (1 + x + 31 * m / 12) % 7;

        calendar = new int[6][7];

        int day = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = startingDayOfWeek; j < 7; j++) {
                if (day <= daysInMonth) {
                    calendar[i][j] = day;
                    day++;
                }
            }
            startingDayOfWeek = 0;
        }

        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (calendar[i][j] != 0) {
                    System.out.printf("%3d ", calendar[i][j]);
                } else {
                    System.out.print("    ");
                }
            }
            System.out.println();
        }
    }
}

