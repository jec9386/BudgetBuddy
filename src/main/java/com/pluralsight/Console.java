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

    //method for date input and to validate it
    public boolean isValidDate(String input) {
        try {
            LocalDate.parse(input); // This expects yyyy-MM-dd format
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    //method for time input and to validate it
    public boolean isValidTime(String input) {
        try {
            LocalTime.parse(input); // This expects HH:mm format
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
