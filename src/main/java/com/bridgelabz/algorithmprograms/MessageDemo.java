package com.bridgelabz.algorithmprograms;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageDemo {

	public static void main(String[] args) {
	
		String message = "Hello <<name>>, We have your full name as <<full name>> in our system.\n"
					   + "your contact number is 91-xxxxxxxxxx.\n"
					   + "Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016.";
		
		String firstName = "John";
		String fullName = "John Dep";
        String mobileNumber = "91-9563214780";
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = dateFormat.format(date);

        message = message.replaceAll("<<name>>", firstName);
        message = message.replaceAll("<<full name>>", fullName);
        message = message.replaceAll("91-xxxxxxxxxx", mobileNumber);
        message = message.replaceAll("\\d{2}/\\d{2}/\\d{4}", currentDate);

        System.out.println(message);
    }
}