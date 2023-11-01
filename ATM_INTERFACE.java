
import java.util.Scanner;

public class ATM_INTERFACE {

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        double depAmount;
        double wAmount;

        UserAccount user1 = new UserAccount();

        boolean continueTransactions = true;

        while (continueTransactions) {
            try {
                System.out.println("\n\n1. Check balance\n2. Withdraw amount\n3. Deposit amount\n4. Quit");
                int choice = input.nextInt();

                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid selection. Please choose a valid option (1-4).");
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.println("Your Balance: " + user1.checkBalance());
                        break;
                    case 2:
                        System.out.println("Enter amount to be withdrawn: ");
                        if (input.hasNextDouble()) {
                            wAmount = input.nextDouble();
                            if (wAmount < 0) {
                                System.out.println("Invalid amount. Please enter a non-negative amount.");
                            } else if (user1.checkBalance() >= wAmount) {
                                System.out.println("Withdraw Success!\nNew balance: " + user1.withdrawAmount(wAmount));
                            } else {
                                System.out.println("Sorry, Insufficient balance.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a valid amount.");
                        }
                        break;
                    case 3:
                        System.out.println("Enter amount to be deposited: ");
                        if (input.hasNextDouble()) {
                            depAmount = input.nextDouble();
                            if (depAmount < 0) {
                                System.out.println("Invalid amount. Please enter a non-negative amount.");
                            } else {
                                System.out.println("Amount Deposited Successfully!\nYour New Balance: " + user1.depositAmount(depAmount));
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a valid amount.");
                        }
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM.");
                        continueTransactions = false;
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                input.nextLine();
            }
        }
    }
}

class UserAccount {

    double account_balance;

    public UserAccount() {
        account_balance = 0.0;
    }

    public double checkBalance() {
        return account_balance;
    }

    public double withdrawAmount(double wAmount) {
        account_balance -= wAmount;
        return account_balance;
    }

    public double depositAmount(double amountDeposited) {
        account_balance += amountDeposited;
        return account_balance;
    }
}
