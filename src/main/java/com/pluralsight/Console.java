package com.pluralsight;

import java.util.Scanner;

public class Console {//interacting with console class

    Scanner scanner = new Scanner(System.in);


    //recieve an int from user
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


    // recieve String from user
    public String promptForString(String prompt){
        System.out.print(prompt);
        return scanner.nextLine();
    }

}
