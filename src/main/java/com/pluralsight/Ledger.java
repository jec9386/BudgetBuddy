package com.pluralsight;

public class Ledger {
    private static Console console = new Console();
    public static void  displayLedger(){

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

            choice = console.promptForString("Select an option (A/D/P/R/H): ").toUpperCase();

            switch (choice) {
                case "A":
                    //ToDo showTransactions(console, "ALL");
                    break;
                case "D":
                    //ToDo showTransactions(console, "DEPOSIT");
                    break;
                case "P":
                    //ToDo showTransactions(console, "PAYMENT");
                    break;
                case "R":
                    System.out.println("Reports coming soon!");
                    break;
                case "H":
                    return; // goes back to Main
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (!choice.equals("H"));
    }

}


