package com.pluralsight;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    private static Console console = new Console();
    private static ArrayList<Transaction> transactions = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println("Welcome to BudgetBuddy!");

        String option;
        //trap in loop to HomeScreen until user exits.
        do {
            String homeScreenPrompt =
                "                 Home Screen                   \n" +
                        "------------------------------------------------\n" +
                        "Please select an option from the following:\n" +
                        "    D - Add Deposit\n" +
                        "    P - Make Payment(Debit)\n" +
                        "    L - Ledger\n" +
                        "    X - Exit\n" +
                        "(D,P,L,X): ";
            option = console.promptForString(homeScreenPrompt);
            switch (option.toUpperCase()) {
                // prompt user for the deposit information and save it to the csv file
                case "D":
                    System.out.println("Please fill in information below to ADD deposit.");
                    addTransaction(option);
                    break;

                //prompt user for the debit information and save it to the csv file
                case "P":
                    System.out.println("Please fill in information below to Make a Payment(Debit).");
                    addTransaction(option);
                    break;
                //display ledger screen
                case "L":
                    //todo: finish ledger
                    break;
                //exit the application
                case "X":
                    //todo: finish ledger
                    break;

                default:
                    System.out.println("Incorrect selection. Please try again.");
            }


        } while (!option.equals("X"));
    }


    //METHODS---------------------------------------------------------------------------------

    public static void addTransaction(String option){
        //prompts
        LocalDate date = console.promptForDate("Enter date (yyyy-MM-dd): ");
        LocalTime time = console.promptForTime("Enter time (24hrs(Military Time) (HH:mm): ");
        String description = console.promptForString("Enter description: ");
        String vendor = console.promptForString("Enter vendor: ");
        double amount = 0.00 ;
        if(option.equalsIgnoreCase("D")) {
            amount =console.promptForDouble("Enter amount(00.00):$ ");}
        else if (option.equalsIgnoreCase("P")){

            amount = console.promptForDouble("Enter amount(00.00):$ -");
            amount = -Math.abs(amount);
        }

        //create a transaction object to store and retrieve the values from user.
        Transaction transaction = new Transaction(date, time, description, vendor, amount);
        //print out just to screen and to CSV file
        System.out.println("Transaction Details:");
        System.out.println(String.format("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount: $%.2f",
                transaction.getDate(),
                transaction.getTime(),
                transaction.getDescription(),
                transaction.getVendor(),
                transaction.getAmount()));//format nicely for the user to view
        transactions.add(transaction);// append new object to array list
        writeTransactionToCSV(transaction);//save the transaction in the csv file
    }


    // Display the ledger (view transactions from CSV)
    public static void displayLedger() {

    }

    // Write the transaction to a CSV file
    public static void writeTransactionToCSV(Transaction transaction) {
        try {
            //open file and add append data to it.
            FileWriter fileWriter = new FileWriter("transactions.csv", true);  // 'true' to append
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write the transaction data as a CSV formatted line
            bufferedWriter.write(transaction.toCSV());

            // Move to the next line after writing the transaction
            bufferedWriter.newLine();

            // Close the writer to save the data and release resources
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }
}