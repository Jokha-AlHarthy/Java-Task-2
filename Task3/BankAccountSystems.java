import java.util.ArrayList;

public class BankAccountSystems {
    public static void main(String[] args){

        //Create lists to store data
        ArrayList<Integer>accountNumbers= new ArrayList<>();
        ArrayList<String>customerNames = new ArrayList<>();
        ArrayList<Double>balances = new ArrayList<>();

        //Add at least 10 books with their authors and availability status
        int accCount = 0;
        while(accCount < 10){
            IO.println("Please enter customer account number: ");
            accountNumbers.add(Integer.parseInt(IO.readln()));
            IO.println("Please enter customer name: ");
            customerNames.add(IO.readln());
            IO.println("Please enter balances available in account: ");
            balances.add(Double.parseDouble(IO.readln()));
            accCount++;
        }

        //Create a menu using switch case
        int choice = 0;
        while(choice!= 6){
            System.out.println("Machine menu");
            System.out.println("1.Display all accounts");
            System.out.println("2.Deposit money");
            System.out.println("3.Withdraw money");
            System.out.println("4.Check account balance");
            System.out.println("5.Display account statistics");
            System.out.println("6.Exit the program");

            IO.println("Please choose one of the choices: ");
            choice = Integer.parseInt(IO.readln());

            switch (choice){
                case 1:
                    displayAccounts(accountNumbers, customerNames, balances);
                    break;
                case 2:
                    IO.println("Please enter account number: ");
                    int accountNumber = Integer.parseInt(IO.readln());
                    IO.println("Please enter amount you want to deposit: ");
                    double amount = Double.parseDouble(IO.readln());
                    depositMoney(accountNumbers,balances , accountNumber, amount);
                    break;
                case 3:
                    IO.println("Please enter account number: ");
                    int accNumber = Integer.parseInt(IO.readln());
                    IO.println("Please enter amount you want to with draw");
                    double amountWithdraw = Double.parseDouble(IO.readln());
                    withdrawMoney(accountNumbers, balances , accNumber, amountWithdraw);
                    break;
                case 4:
                    IO.println("Please enter account number: ");
                    int accNumber1 = Integer.parseInt(IO.readln());
                    checkBalance(balances, accountNumbers,accNumber1);
                    break;
                case 5:
                    calculateStatistics(balances);
                    break;
                case 6:
                    System.out.println("Exit the program");
                    break;
                default:
                    System.out.println("Invalid number");
            }
        }
    }

    //Create a method named displayAccounts() to display all account information
    public static void displayAccounts(ArrayList<Integer>accountNumbers, ArrayList<String>customerNames, ArrayList<Double>balances){
        for(int i=0; i < accountNumbers.size(); i++){
            System.out.println("Account number is: "+accountNumbers.get(i));
            System.out.println("Account customer name: "+customerNames.get(i));
            System.out.println("Account balance"+balances.get(i));
        }
    }

    //Create a method named depositMoney()
    public static void depositMoney(ArrayList<Integer>accountNumbers, ArrayList<Double>balances , int accountNumber, double amount){
        for(int i=0; i < accountNumbers.size(); i++) {
            if (accountNumbers.get(i) == accountNumber) {
                balances.set(i, balances.get(i) + amount);
                System.out.println("Deposit successful.");
                System.out.println("New balance: " + balances.get(i));
                return;
            }
        }
        System.out.println("Account not found..");
    }

    //Create a method named withdrawMoney()
    public static void withdrawMoney(ArrayList<Integer>accountNumbers, ArrayList<Double>balances , int accountNumber, double amountWithdraw){
        for(int i=0; i < accountNumbers.size(); i++){
            if(accountNumbers.get(i) == accountNumber){
                balances.set(i, balances.get(i) - amountWithdraw);
                System.out.println("Withdrawal successful");
                System.out.println("New balance: " + balances.get(i));
            }else{
                System.out.println("Insufficient balance..");
            }
            return;
        }
    }

    //Create a method named checkBalance()
    public static void checkBalance(ArrayList<Double>balances, ArrayList<Integer>accountNumbers, int accountNumber) {
        for (int i = 0; i < accountNumbers.size(); i++) {
            if (accountNumbers.get(i) == accountNumber) {
                System.out.println("Current balance: " + balances.get(i));
                return;
            }
        }
        System.out.println("Account not found..");
    }

    //Create a method named calculateStatistics()
    public static void calculateStatistics(ArrayList<Double>balances) {
        double totalMoney = 0;
        double highestBalance = balances.get(0);
        double lowestBalance = balances.get(0);
        double specficAboeamount = 1000;
        int accountsAboveAmount = 0;

        for (double balance : balances) {
            totalMoney += balance;
            if (balance > highestBalance) {
                highestBalance = balance;
            }else if (balance < lowestBalance) {
                lowestBalance = balance;
            }else if (balance > specficAboeamount){
                accountsAboveAmount++;
            }
        }
        System.out.println("Account Statistics");
        System.out.println("Total money in all accounts: " + totalMoney);
        System.out.println("Highest account balance: " + highestBalance);
        System.out.println("Lowest account balance: " + lowestBalance);
        System.out.println("Number of accounts with balance above"+specficAboeamount+":"+accountsAboveAmount);
    }

}
