import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank sbi = new Bank();

        while (true) {
            System.out.println("=================Bank System==================");
            System.out.println("select 1.create Account");
            System.out.println("select 2.Deposit Account");
            System.out.println("select 3.Withdraw Account");
            System.out.println("select 4.Check Balance");
            System.out.println("select 5.To Exit or any key");

            int op = sc.nextInt();
            if (op < 5 && op > 0) {
                System.out.print("Enter Account Number  ::");
                long accNo = sc.nextLong();
                if (op == 1) {
                    sc.nextLine();
                    System.err.print("Enter Your Name  ::");
                    String name = sc.nextLine();

                    BankAccount ba = new BankAccount(accNo, name);
                    sbi.addBankAccount(ba);

                    System.out.println("Account Created... ");
                } else if (op == 2) {
                    BankAccount selectedAccount = sbi.SelectAccount(accNo);

                    if (selectedAccount != null) {
                        System.out.print("Enter Money you want to deposit :");
                        double money = sc.nextDouble();
                        selectedAccount.depositMoney(money);
                    } else {
                        System.out.println("Please Enter Valid Account Number... ");
                    }
                } else if (op == 3) {
                    BankAccount selectedAccount = sbi.SelectAccount(accNo);
                    if (selectedAccount != null) {
                        System.out.print("Enter Money you want to Withdraw :");
                        double money = sc.nextDouble();
                        selectedAccount.withdrawMoney(money);
                    } else {
                        System.out.println("Please Enter Valid Account Number... ");
                    }
                } else if (op == 4) {
                    BankAccount selectedAccount = sbi.SelectAccount(accNo);
                    if (selectedAccount != null) {
                        System.out.println("Bank Balance ::" + selectedAccount.checkBankBalance());
                    } else {
                        System.out.println("Please Enter Valid Account Number... ");
                    }
                }
            } else {
                System.out.println("Thank You For Using Bank System...");
                break;
            }
            sc.close();
        }
    }
}
