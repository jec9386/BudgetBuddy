package com.pluralsight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Ledger {
    private static Console console = new Console();
    public static void  displayLedger(ArrayList<Transaction> transactions){//get access to transactions by accepting an ArrayList of type Transaction objects

        String choice;

        do {
            System.out.println(
                    "\nWelcome to Ledger Options\n" +
                    "-------------------------\n" +
                    "A) All - Display all entries\n" +
                    "D) Deposits - Display only deposits\n" +
                    "P) Payments - Display only payments\n" +
                    "R) Reports\n" +
                    "H) Home");

            choice = console.promptForString("Select an option (A/D/P/R/H): ");

            if (choice.equalsIgnoreCase("A")) {
                showTransactions(transactions, "All");
            } else if (choice.equalsIgnoreCase("D")) {
                showTransactions(transactions, "Deposit");
            } else if (choice.equalsIgnoreCase("P")) {
                showTransactions(transactions, "Payment");
            } else if (choice.equalsIgnoreCase("R")) {
                System.out.println("Reports coming soon!");
            } else if (choice.equalsIgnoreCase("H")) {
                return; // exits the loop and returns to main
            } else {
                System.out.println("Invalid option. Please try again.");
            }

        } while (!choice.equalsIgnoreCase("H"));
    }

    //displayLedger() depending on user input All, deposit, payment
    public static void showTransactions(ArrayList<Transaction> transactions, String type) {
        // Sort newest to oldest
        Collections.sort(transactions, new Comparator<Transaction>() {//use Collections class to sort the list to newest on top. and Comparator helper tool to compare the objects you are ordering
            @Override
            public int compare(Transaction t1, Transaction t2) {//compare to see if t2 is newer than t1
                if (t2.getDate().equals(t1.getDate())) {//compare date
                    return t2.getTime().compareTo(t1.getTime());//if date is equal compare if t2 time is newer
                } else {
                    return t2.getDate().compareTo(t1.getDate());// if date is different we sort by newest first
                }
            }
        });

        System.out.println("\n" + type + " Transactions");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Date        | Time     | Description       | Vendor           | Amount");
        System.out.println("--------------------------------------------------------------------------");

        for (Transaction t : transactions) {//t = transaction, loop through transactions array, and depending on which value user input it will select that.
            boolean matches = type.equals("All") ||
                    (type.equals("Deposit") && t.getAmount() > 0) ||
                    (type.equals("Payment") && t.getAmount() < 0);

            if (matches) {
                System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount: $%.2f\n",
                        t.getDate(),
                        t.getTime(),
                        t.getDescription(),
                        t.getVendor(),
                        t.getAmount());
            }
        }
    }

}


