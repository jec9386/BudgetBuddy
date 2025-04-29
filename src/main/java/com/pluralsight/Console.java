package com.pluralsight;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Console {//interacting with console class

    Scanner scanner = new Scanner(System.in);


    //receive an int from user
    public int promptForInt(String prompt/*take in a string called prompt*/){
        boolean hasResult = false;
        int result = -1;
        while(!hasResult) {
            try{
                System.out.print(prompt);
                result = scanner.nextInt();
                scanner.nextLine();
                hasResult = true;

            } catch (Exception e) {
                System.out.println("Invalid entry, please try again!");
                scanner.next();
            }
        }

        return result;

    }


    // receive String from user
    public String promptForString(String prompt){
        System.out.print(prompt);
        return scanner.nextLine();
    }

    //receive Double from user
    public double promptForDouble(String prompt/*take in a string called prompt*/){
        boolean hasResult = false;
        double result = -1;
        while(!hasResult) {
            try{
                System.out.print(prompt);
                result = scanner.nextDouble();
                scanner.nextLine();
                hasResult = true;

            } catch (Exception e) {
                System.out.println("Invalid entry, please try again!");
                scanner.next();
            }
        }

        return result;

    }

    //method for date prompt,validation, and conversion
    public LocalDate promptForDate(String prompt) {
        LocalDate date = null;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            try {
                date = LocalDate.parse(input);//convert String to date
                valid = true; // If input is date, stop the loop
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
            }
        }

        return date;
    }

    //method for time prompt, validation, and conversion
    public LocalTime promptForTime(String prompt) {
        LocalTime time = null;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            try {
                time = LocalTime.parse(input);
                valid = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Please enter the time in HH:mm format (e.g., 14:30).");
            }
        }

        return time;
    }

}
