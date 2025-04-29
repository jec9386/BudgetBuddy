package com.pluralsight;



public class Main {
    private static Console console = new Console();

    public static void main(String[] args) {
        System.out.println("Welcome to BudgetBuddy!");

        String homeScreenPrompt =
                "                 Home Screen                   \n" +
                        "------------------------------------------------\n" +
                        "Please select an option from the following:\n" +
                        "    D - Add Deposit\n" +
                        "    P - Make Payment(Debit)\n" +
                        "    L - Ledger\n" +
                        "    X - Exit\n" +
                        "(D,P,L,X): ";


        String option;
        //trap in loop to HomeScreen until user exits.
        do {
            option = console.promptForString(homeScreenPrompt);
            switch (option.toUpperCase()) {
                // prompt user for the deposit information and save it to the csv file
                case "D":

                    break;

                //prompt user for the debit information and save it to the csv file
                case "P":

                    break;
                //display ledger screen
                case "L":

                    break;
                //exit the application
                case "X":

                    break;

                default:
                    System.out.println("Incorrect selection. Please try again.");
            }


        } while (!option.equals("X"));
    }
}