package com.bridgelabz.datastructureprograms;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;

public class CalendarQueue  {
	
	class WeekDay {
	
		String day;
		String date;

		WeekDay(String day, String date) {
			this.day = day;
			this.date = date;
		}
	}
	
	class Week {
		
		Queue<WeekDay> week;

		Week() {
			this.week = new LinkedList<WeekDay>();
		}

		public void addDay(WeekDay day) {
			this.week.add(day);
		}

		public void printWeek() {
			for (WeekDay wd : week) {
				System.out.println(wd.day + " " + wd.date);
			}
		}
	}
	
	public static void main(String[] args) {
	
		int month = Integer.parseInt(args[0]);
	    int year = Integer.parseInt(args[1]);

	    String[] days = {"S", "M", "T", "W", "Th", "F", "S"};
	    Calendar cal = Calendar.getInstance();
	    cal.set(year, month - 1, 1);
	    int firstDay = cal.get(Calendar.DAY_OF_WEEK) - 1;

	    cal.set(year, month, 0);
	    int numDays = cal.get(Calendar.DAY_OF_MONTH);

	    Queue<Week> monthCalendar = new LinkedList<Week>();
	    Week currentWeek = new Week();

	    int currDay = 1;
	    for (int i = 0; i < 7; i++) {
	    	if (i < firstDay) {
	    		currentWeek.addDay(new WeekDay(days[i], ""));
	    	} else {
	    		currentWeek.addDay(new WeekDay(days[i], Integer.toString(currDay)));
	    		currDay++;
	    	}
	    }
	    monthCalendar.add(currentWeek);

	    while (currDay <= numDays) {
	    	currentWeek = new Week();
	    	for (int i = 0; i < 7; i++) {
	    		if (currDay <= numDays) {
	    			currentWeek.addDay(new WeekDay(days[i], Integer.toString(currDay)));
	    		} else {
	    			currentWeek.addDay(new WeekDay(days[i], ""));
	    		}
	    		currDay++;
	    	}
	    	monthCalendar.add(currentWeek);
	    }

	    for (Week w : monthCalendar) {
	    	w.printWeek();
	    	System.out.println();
	    }
	}
}
