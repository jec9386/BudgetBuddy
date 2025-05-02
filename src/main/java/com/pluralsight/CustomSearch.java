package com.pluralsight;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomSearch {
    private static Console console = new Console();

    public static void displayCustomSearch(ArrayList<Transaction> transactions) {
        int choice;

        do {
            String customSearchScreenPrompt =
                    "\n                 Custom Search Options                 \n" +
                            "------------------------------------------------\n" +
                            "Please select a custom search option:\n" +
                            "    1 - Start date\n" +
                            "    2 - End date(inclusive)\n" +
                            "    3 - Description\n" +
                            "    4 - Vendor\n" +
                            "    5 - Amount\n" +
                            "    0 - Back\n" +
                            "Select an option (1-5, or 0 to go back to Report Options): ";

            choice = console.promptForInt(customSearchScreenPrompt);

            switch (choice) {
                case 1:
                    showStartDateToNow(transactions);
                    break;
                case 2:
                    showAllTransactionsUpToEndDate(transactions);
                    break;
                case 3:
                    showByDescription(transactions);
                    break;
                case 4:
                    showByVendor(transactions);
                    break;
                case 5:
                    showByAmount(transactions);
                    break;
                case 0:
                    return; // back to previous menu
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (true);
    }


//------------------METHODS-----------------------------------------------------------------------------

    //custom search form a start date
    private static void showStartDateToNow(ArrayList<Transaction> transactions) {
        Ledger.sortTransactions(transactions); // Sort if needed
        LocalDate startDate = console.promptForDate("Enter start date (yyyy-MM-dd): ");
        LocalDate today = LocalDate.now();
        boolean found = false;

        for (Transaction t : transactions) {
            LocalDate transactionDate = t.getDate();//set date to variable to better compare it
            if ((transactionDate.isEqual(startDate) || transactionDate.isAfter(startDate)) &&
                    !transactionDate.isAfter(LocalDate.now())) {//transaction is equal to the start date or transaction is after start date up to now/
                System.out.println(t.toPretty());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No transactions found from that date to now.");
        }
    }

    //custom end date not just now
    private static void showAllTransactionsUpToEndDate(ArrayList<Transaction> transactions) {
        Ledger.sortTransactions(transactions);
        LocalDate endDate = console.promptForDate("Enter the end date (yyyy-MM-dd) to get transactions up to that date: ");
        boolean found = false;

        for (Transaction t : transactions) {
            LocalDate transactionDate = t.getDate();
            if (!transactionDate.isAfter(endDate)) {//if the date isn't after the endDate print it.
                System.out.println(t.toPretty());
                found = true;
            }
            if (!found) {
                System.out.println("No transactions found up to the specified end date.");
            }

        }
    }


    //custom transaction search by description
    private static void showByDescription(ArrayList<Transaction> transactions) {
        Ledger.sortTransactions(transactions);
        String description = console.promptForString("Enter description: ");

        boolean found = false; //this needs to be true there be a transaction the user is looking for
        for (Transaction t : transactions) {
            if (t.getDescription().equalsIgnoreCase(description)) {
                System.out.println(t.toPretty());
                found = true;
            }
        }
        if (!found) {// If no object during iteration turns found to true then print this so user knows.
            System.out.println("No transactions found for that description.");
        }
    }

    //custom transaction search by vendor
    private static void showByVendor(ArrayList<Transaction> transactions) {
        Ledger.sortTransactions(transactions);
        String vendor = console.promptForString("Enter vendor name: ");

        boolean found = false; //this needs to be true there be a transaction the user is looking for
        for (Transaction t : transactions) {
            if (t.getVendor().equalsIgnoreCase(vendor)) {
                System.out.println(t.toPretty());
                found = true;
            }
        }

        if (!found) {// If no object during iteration turns found to true then print this so user knows.
            System.out.println("No transactions found for that vendor.");
        }


    }

    //custom transaction search by amount
    private static void showByAmount(ArrayList<Transaction> transactions) {
        Ledger.sortTransactions(transactions);
        System.out.println("Enter amount to search (e.g., -100.00 for payments, 250.00 for deposits, DON'T add comma): ");
        double amountToSearch = console.promptForDouble("Amount: $");

        boolean found = false; //this needs to be true there be a transaction the user is looking for
        for (Transaction t : transactions) {
            if (t.getAmount() == amountToSearch) {
                System.out.println(t.toPretty());
                found = true;
            }
        }


        if (!found) {// If no object during iteration turns found to true then print this so user knows.
            System.out.println("No transactions found for that amount.");
        }
    }
}