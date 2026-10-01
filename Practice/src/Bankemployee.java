import java.util.Scanner;
public class Bankemployee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String custname = sc.nextLine();

        System.out.print("Enter account number: ");
        int Accno = sc.nextInt();

        System.out.print("Enter the account balance: ");
        int accbalance = sc.nextInt();

        sc.nextLine(); 

        System.out.print("Enter the account type: ");
        String acctype = sc.nextLine();

        System.out.println("\n--- Customer Details ---");
        System.out.println("Name: " + custname);
        System.out.println("Account Number: " + Accno);
        System.out.println("Balance: " + accbalance);
        System.out.println("Account Type: " + acctype);

        System.out.print("\nEnter number to withdraw: ");
        int num = sc.nextInt();

        if (num > accbalance) {
            System.out.println("INSUFFICIENT BALANCE");
        } else {
            System.out.println("The amount " + num + " is withdrawn from your bank.");
            System.out.println("The remaining balance is: " + (accbalance - num));
        }

        sc.close();
    }
}
