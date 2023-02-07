package com.bridgelabz.datastructureprograms;

import java.util.LinkedList;

public class CalendarQueueStack {
	
	class WeekDay {
	    private String day;
	    private int date;

	    public WeekDay(String day, int date) {
	        this.day = day;
	        this.date = date;
	    }

	    public String getDay() {
	        return day;
	    }

	    public int getDate() {
	        return date;
	    }
	}
	
	class Week {
	    private LinkedList<WeekDay> weekDays;

	    public Week() {
	        weekDays = new LinkedList<>();
	    }

	    public void addWeekDay(WeekDay weekDay) {
	        weekDays.add(weekDay);
	    }

	    public LinkedList<WeekDay> getWeekDays() {
	        return weekDays;
	    }
	}
	
	class Stack {
	    private LinkedList<Week> stack;

	    public Stack() {
	        stack = new LinkedList<>();
	    }

	    public void push(Week week) {
	        stack.push(week);
	    }

	    public Week pop() {
	        if (stack.isEmpty()) {
	            return null;
	        }
	        return stack.pop();
	    }

	    public boolean isEmpty() {
	        return stack.isEmpty();
	    }
	}
	
	class Calendar {
	    private Stack stack1;
	    private Stack stack2;

	    public Calendar() {
	        stack1 = new Stack();
	        stack2 = new Stack();
	    }

	    public void addWeek(Week week) {
	        stack1.push(week);
	    }

	    public void displayCalendar() {
	        while (!stack1.isEmpty()) {
	            stack2.push(stack1.pop());
	        }
	        while (!stack2.isEmpty()) {
	            Week week = stack2.pop();
	            LinkedList<WeekDay> weekDays = week.getWeekDays();
	            for (WeekDay weekDay : weekDays) {
	                System.out.println(weekDay.getDay() + " " + weekDay.getDate());
	            }
	        }
	    }
	}
	public static void main(String[] args) {
		
		Calendar calendar = new Calendar();
		Week week1 = new Week();
		week1.addWeekDay(new WeekDay("S", 1));
		week1.addWeekDay(new WeekDay("M", 2));
		week1.addWeekDay(new WeekDay("T", 3));
		calendar.addWeek(week1);

		Week week2 = new Week();
		week2.addWeekDay(new WeekDay("W", 4));
		week2.addWeekDay(new WeekDay("Th", 5));
		week2.addWeekDay(new WeekDay("F", 6));
		calendar.addWeek(week2);	
		calendar.displayCalendar();
	}
}

	