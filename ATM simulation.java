import java.util.Scanner;

public class SimpleATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 1000.0;
        int choice;
        
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1 -> System.out.println("Balance: ₹" + balance);
                case 2 -> {
                    System.out.print("Enter deposit amount: ");
                    double amt = sc.nextDouble();
                    balance += amt;
                }
                case 3 -> {
                    System.out.print("Enter withdraw amount: ");
                    double amt = sc.nextDouble();
                    if (amt <= balance) balance -= amt;
                    else System.out.println("Insufficient funds!");
                }
                case 4 -> System.out.println("Thank you!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}