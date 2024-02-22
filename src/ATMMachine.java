import java.util.Scanner;

public class ATMMachine {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ATMMachine atmMachine = new ATMMachine();
        atmMachine.start();
    }

    public void start() {
        System.out.println("Welcome to the ATM Machine!");
        boolean cardVerified = verifyCardDetails();
        if (cardVerified) {
            boolean pinVerified = verifyPin();
            if (pinVerified) {
                String language = chooseLanguage();
                displayAccountDetails(language);
                displayOptions();
            } else {
                System.out.println("Invalid PIN. Exiting...");
            }
        } else {
            System.out.println("Card verification failed. Exiting...");
        }
    }

    public boolean verifyCardDetails() {
        System.out.println("Enter card number:");
        String cardNumber = scanner.nextLine();
        return cardNumber.length() == 16;
    }

    public boolean verifyPin() {
        System.out.println("Enter PIN:");
        String pin = scanner.nextLine();
        return pin.equals("1234");
    }

    public String chooseLanguage() {
        System.out.println("Choose language:");
        System.out.println("1. English");
        System.out.println("2. Tamil");
        int choice = Integer.parseInt(scanner.nextLine());
        String selectedLanguage = "English";
        switch (choice) {
            case 1:
                System.out.println("You have chosen English.");
                selectedLanguage = "English";
                break;

            case 2:
                System.out.println("You have chosen Tamil.");
                selectedLanguage = "Tamil";
                break;
            default:
                System.out.println("Invalid choice. English selected by default.");
                selectedLanguage = "English";
        }
        return selectedLanguage;
    }

    public void displayAccountDetails(String language) {
        String accountHolderName = "Charan";
        String accountNumber = "1234567890";
        String balance = "₹1000";

        System.out.println("Account Holder Details:");
        System.out.println("Language: " + language);
        System.out.println("Name: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    public void displayOptions() {
        System.out.println("Select an option:");
        System.out.println("1. Withdrawal");
        System.out.println("2. Check Balance");
        System.out.println("3. Change PIN");
        System.out.println("4. Fund Transfer");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.println("Withdrawal option selected.");
                break;
            case 2:
                System.out.println("Check Balance option selected.");
                break;
            case 3:
                System.out.println("Change PIN option selected.");
                break;
            case 4:
                System.out.println("Fund Transfer option selected.");
                break;
            default:
                System.out.println("Invalid option selected.");
                // PR testing
        }
    }
}
