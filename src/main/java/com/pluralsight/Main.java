package com.pluralsight;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    private static Console console = new Console();
    private static ArrayList<Transaction> transactions = new ArrayList<>();


    public static void main(String[] args) {

        //First thing I want file to do is to load the String from transactions.csv file into the ArrayList.
        loadTransactionsFromCSV();

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

                    Ledger.displayLedger(transactions);

                    break;
                //exit the application
                case "X":
                    System.out.println("Thank you for using BudgetBuddy. See you next time!");
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
        //print out inputs to screen and add to CSV file
        System.out.println("Transaction Details:");
        System.out.println(transaction.toPretty());//output nicely formated String for the user to review their input
        transactions.add(transaction);// append new object to array list
        writeTransactionToCSV(transaction);//save the transaction in the csv file
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

    //method to load CSV file into an ArrayList
    public static void loadTransactionsFromCSV() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"));//grab/open file and Buffer makes reading faster
            String line;

            while ((line = reader.readLine()) != null) {//get entire line from file as string and save into line until no more strings
                if(line.trim().isEmpty()){
                    continue;//skip line if it's empty, dont try to convert it to an object.
                }
                transactions.add(Transaction.fromCSV(line)); // Use fromCSV method to convert CSV line into a Transaction object and add it to Array List
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading from file.");
            e.printStackTrace();
        }
    }
}