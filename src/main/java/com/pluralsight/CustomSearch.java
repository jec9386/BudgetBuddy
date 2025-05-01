package com.pluralsight;

import java.util.ArrayList;

public class CustomSearch {
    private static Console console = new Console();

    public static void displayCustomSearch(ArrayList<Transaction> transactions) {
        int choice;

        do{
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


    private static void showStartDateToNow(ArrayList<Transaction> transactions)

    //
    private static void showAllTransactionsUpToEndDate(ArrayList<Transaction> transactions)

    //
    private static void showByDescription(ArrayList<Transaction> transactions)

    //custom transaction search by vendor
    private static void showByVendor(ArrayList<Transaction> transactions) {
        Ledger.sortTransactions(transactions);
        String vendor = console.promptForString("Enter vendor name: ");
        for (Transaction t : transactions) {
            if (t.getVendor().equalsIgnoreCase(vendor)) {
                System.out.println(t.toPretty());
            }
        }
    }

    //
    private static void showByAmount(ArrayList<Transaction> transactions)

}
