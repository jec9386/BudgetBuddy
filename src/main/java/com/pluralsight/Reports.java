package com.pluralsight;

import java.util.ArrayList;
import java.time.LocalDate;


public class Reports {
    private static Console console = new Console();

    public static void displayReports(ArrayList<Transaction> transactions) {
        int choice;

        do{
            String reportsScreenPrompt =
                    "                 Reports Menu                  \n" +
                            "------------------------------------------------\n" +
                            "Please select a report option:\n" +
                            "    1 - Month to Date\n" +
                            "    2 - Month\n" +
                            "    3 - Previous Month\n" +
                            "    4 - Year to Date\n" +
                            "    5 - Previous Year\n" +
                            "    6 - Search by Vendor\n" +
                            "    0 - Back\n" +
                            "Select an option (1-6, or 0 to go back to ledger options): ";

            choice = console.promptForInt(reportsScreenPrompt);

            switch (choice) {
                case 1:
                    showMonthToDate(transactions);
                    break;
                case 2:
                    showMonth(transactions);
                    break;
                case 3:
                    showPreviousMonth(transactions);
                    break;
                case 4:
                    showYearToDate(transactions);
                    break;
                case 5:
                    showPreviousYear(transactions);
                    break;
                case 6:
                    searchByVendor(transactions);
                    break;
                case 0:
                    return; // back to previous menu
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (true);
    }
    //--------------METHODS---------------------------------------------------------------------------------------------------

    //show all transactions for the current month to current date
    //my logic why I did up to but not after is because, factor in autopayment like for rent
    private static void showMonthToDate(ArrayList<Transaction> transactions) {
        Ledger.sortTransactions(transactions);
        LocalDate today = LocalDate.now();
        for (Transaction t : transactions) {
            if (t.getDate().getMonth() == today.getMonth() &&// looks at the date of the object and pull the month from it to compare with today's month
                    t.getDate().getYear() == today.getYear()&&// looks at the year
                    !t.getDate().isAfter(today)) //makes sure the date is not after today's date
            {
                System.out.println(t.toPretty());
            }
        }
    }

    //show transactions for this month
    private static void showMonth(ArrayList<Transaction> transactions) {
        Ledger.sortTransactions(transactions);
        LocalDate today = LocalDate.now();
        for (Transaction t : transactions) {
            if (t.getDate().getMonth() == today.getMonth() &&// looks at the date of the object and pull the month from it to compare with today's month
                    t.getDate().getYear() == today.getYear()) // looks at the year
            {
                System.out.println(t.toPretty());
            }
        }
    }

    //show  transactions for the previous month
    private static void showPreviousMonth(ArrayList<Transaction> transactions) {
        Ledger.sortTransactions(transactions);
        LocalDate today = LocalDate.now();
        LocalDate lastMonth = today.minusMonths(1);//get today's month and minus one to get last month

        for (Transaction t : transactions) {
            if (t.getDate().getMonth() == lastMonth.getMonth() &&
                    t.getDate().getYear() == lastMonth.getYear()) {
                System.out.println(t.toPretty());
            }
        }
    }

    //show transactions for year up to today's date
    private static void showYearToDate(ArrayList<Transaction> transactions) {
        Ledger.sortTransactions(transactions);
        LocalDate today = LocalDate.now();
        for (Transaction t : transactions ) {
            if (t.getDate().getYear() == today.getYear() && !t.getDate().isAfter(today)) {
                System.out.println(t.toPretty());
            }
        }
    }

    //show transactions for the previous year
    private static void showPreviousYear(ArrayList<Transaction> transactions) {
        Ledger.sortTransactions(transactions);
        int lastYear = LocalDate.now().getYear() - 1;
        for (Transaction t : transactions) {
            if (t.getDate().getYear() == lastYear) {
                System.out.println(t.toPretty());
            }
        }
    }

    //custom transaction search by vendor
    private static void searchByVendor(ArrayList<Transaction> transactions) {
        Ledger.sortTransactions(transactions);
        String vendor = console.promptForString("Enter vendor name: ");
        for (Transaction t : transactions) {
            if (t.getVendor().equalsIgnoreCase(vendor)) {
                System.out.println(t.toPretty());
            }
        }
    }

}



