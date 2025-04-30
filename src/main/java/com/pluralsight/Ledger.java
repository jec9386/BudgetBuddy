package com.pluralsight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Ledger {
    private static Console console = new Console();

    public static void displayLedger(ArrayList<Transaction> transactions) {//get access to transactions by accepting an ArrayList of type Transaction objects

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
                showAll(transactions, "All");
            } else if (choice.equalsIgnoreCase("D")) {
                showDeposits(transactions, "Deposit");
            } else if (choice.equalsIgnoreCase("P")) {
                showPayments(transactions, "Payment");
            } else if (choice.equalsIgnoreCase("R")) {
                //TODO add report screen and prompt
            } else if (choice.equalsIgnoreCase("H")) {
                return; // exits the loop and returns to main
            } else {
                System.out.println("Invalid option. Please try again.");
            }

        } while (!choice.equalsIgnoreCase("H"));
    }


    //--------METHOD SECTION----------------------------------------------------------------------------------------------------

    //Display all transactions deposit and payment
    public static void showAll(ArrayList<Transaction> transactions) {
        // Sort newest to oldest
        sortTransactions(transactions);

        System.out.println(Transaction.getPrettyHeader("All"));

        for (Transaction t : transactions) {
            System.out.println(t.toPretty());
        }
    }

    //Display all deposits only
    public static void showDeposits(ArrayList<Transaction> transactions) {

        sortTransactions(transactions);

        System.out.println(Transaction.getPrettyHeader("Deposits"));

        for (Transaction t : transactions) {
            if (t.getAmount() > 0) {
                System.out.println(t.toPretty());
            }
        }
    }

    //Display all payments only
    public static void showPayments(ArrayList<Transaction> transactions) {

        sortTransactions(transactions);

        System.out.println(Transaction.getPrettyHeader("Payments"));

        for (Transaction t : transactions) {
            if (t.getAmount() < 0) {
                System.out.println(t.toPretty());
            }
        }
    }


    //sort from newest on top by date and time.
    private static void sortTransactions(ArrayList<Transaction> transactions) {
        Collections.sort(transactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction first, Transaction second) {
                // If both transactions happened on the same date
                if (second.getDate().equals(first.getDate())) {
                    // Compare by time, newer times come first
                    return second.getTime().compareTo(first.getTime());
                } else {
                    // Compare by date, newer dates come first
                    return second.getDate().compareTo(first.getDate());
                }
            }
        });
    }


/*   NOTE!! Original code to show all transaction +(deposit and payments)- professor said its better to simplify code for readability. But keep here just to give you another way of writing this part of the code.
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

        System.out.println(Transaction.getPrettyHeader(type));

        for (Transaction t : transactions) {//t = transaction, loop through transactions array, and depending on which value user input it will select that.
            boolean matches = type.equals("All") ||
                    (type.equals("Deposit") && t.getAmount() > 0) ||
                    (type.equals("Payment") && t.getAmount() < 0);

            if (matches) {
                System.out.println(t.toPretty());
            }
        }
    }
*/
    }

}
