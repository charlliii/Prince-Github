import java.time.*;
import java.time.format.*;
import java.util.*;

class ATM1 {
    private long accountBalance = 9682648662L;
    private int loginAttempts = 3;
    private final ArrayList<String> transactionHistory = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    private final String CORRECT_USERNAME = "Prince";
    private final int CORRECT_PASSWORD = 7;
    private final int CORRECT_PIN = 8002;
    private final int BALANCE_PASSWORD = 8003;

    // Date time Formatter
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd hh:mm:ss a");
    String formattedDateTime = currentDateTime.format(formatter);

    public void start() {
        while (loginAttempts > 0) {
            try {
                System.out.print("Username: ");
                String userName = sc.next();
                System.out.print("Password: ");
                int pass = sc.nextInt();

                if (userName.equals(CORRECT_USERNAME) && pass == CORRECT_PASSWORD) {
                    int choice;
                    do {
                        System.out.println("\nEnter your choice:");
                        System.out.println("1. Deposit Money");
                        System.out.println("2. Withdraw amount");
                        System.out.println("3. Check Account balance");
                        System.out.println("4. Transaction History");
                        System.out.println("5. Exit ATM");

                        choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("Enter amount to deposit");
                                int deposit = sc.nextInt();
                                if (deposit > 0) {
                                    accountBalance += deposit;
                                    String log = "Deposited: " + deposit + " at " + formattedDateTime;
                                    transactionHistory.add(log);

                                    System.out.println("Your account is credited with INR " + deposit + " on " + formattedDateTime);
                                    System.out.println("AvlBal: Rs" + accountBalance);
                                } else {
                                    System.out.println("Invalid deposit amount!");
                                }
                                break;

                            case 2:
                                System.out.println("Enter amount to withdraw:");
                                int amount = sc.nextInt();
                                int pinAttempts = 3;
                                System.out.println("Enter PIN:");

                                while (pinAttempts > 0) {
                                    try {
                                        int pin = sc.nextInt();
                                        if (pin == CORRECT_PIN) {
                                            if (accountBalance < amount) {
                                                System.out.println("Insufficient balance!");
                                            } else {
                                                accountBalance -= amount;
                                                String log = "Withdrew: " + amount + " at " + formattedDateTime;
                                                transactionHistory.add(log);
                                                System.out.println("Amount " + amount + " withdrawn successfully. At " + formattedDateTime);
                                                System.out.println("AvlBal: Rs" + accountBalance);
                                            }
                                            break;
                                        } else {
                                            pinAttempts--;
                                            System.out.println("Incorrect PIN. Attempts left: " + pinAttempts);
                                            if (pinAttempts == 0) {
                                                System.out.println("Account has been blocked! Visit your bank to unblock your account");
                                            }
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input! Please enter the correct type of data.");
                                        sc.nextLine();
                                    }
                                }
                                break;

                            case 3:
                                int balanceAttempts = 3;
                                System.out.println("Enter password to check balance:");
                                while (balanceAttempts > 0) {
                                    try {
                                        int password = sc.nextInt();
                                        if (password == BALANCE_PASSWORD) {
                                            System.out.println("Account Balance: " + accountBalance);
                                            break;
                                        } else {
                                            balanceAttempts--;
                                            System.out.println("Incorrect password. Attempts left: " + balanceAttempts);
                                            if (balanceAttempts == 0) {
                                                System.out.println("Account has been blocked! Visit your bank to unblock your account");
                                            }
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input! Please enter the correct type of data.");
                                        sc.nextLine();
                                    }
                                }
                                break;

                            case 4:
                                System.out.println("Transaction History:");
                                if (transactionHistory.isEmpty()) {
                                    System.out.println("No transactions yet.");
                                } else {
                                    for (String entry : transactionHistory) {
                                        System.out.println(entry);
                                    }
                                }
                                break;

                            case 5:
                                System.out.println("Exiting ATM. Thank you for visiting!");
                                break;

                            default:
                                System.out.println("Invalid choice. Try again.");
                        }

                    } while (choice != 5);

                    break;

                } else {
                    loginAttempts--;
                    System.out.println("Incorrect USERNAME or PASSWORD. Attempts left: " + loginAttempts);
                    if (loginAttempts == 0) {
                        System.out.println("Account has been blocked! Visit your bank to unblock your account.");
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter the correct type of data.");
                sc.nextLine();
            }
        }
    }
}

public class ATM_Simulation_System {
    public static void main(String[] args) {
        ATM1 a = new ATM1();
        a.start();
    }
}