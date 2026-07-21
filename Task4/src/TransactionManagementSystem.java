import java.util.ArrayList;

public class TransactionManagementSystem {
    public static void main(String[] args){
        //Create the following ArrayLists

        //1. Account number
        ArrayList<Integer> accountNumbers = new ArrayList<>();

        //2. Customer name
        ArrayList<String> customerNames = new ArrayList<>();

        //3. Current balance
        ArrayList<Double> balances =  new ArrayList<>();

        //4. Account type
        ArrayList<String> accountTypes = new ArrayList<>();

        //5. Account status
        ArrayList<String> accountStatus = new ArrayList<>();

        //6.Store information for at least 10 customer accounts
        accountNumbers.add(10001);
        customerNames.add("Ali");
        balances.add(2500.0);
        accountTypes.add("Savings");
        accountStatus.add("Active");

        accountNumbers.add(10002);
        customerNames.add("Ahmed");
        balances.add(1800.0);
        accountTypes.add("Current");
        accountStatus.add("Active");

        accountNumbers.add(10003);
        customerNames.add("Rashid");
        balances.add(3200.5);
        accountTypes.add("Savings");
        accountStatus.add("Active");

        accountNumbers.add(10004);
        customerNames.add("Khalfan");
        balances.add(950.0);
        accountTypes.add("Current");
        accountStatus.add("Suspended");

        accountNumbers.add(10005);
        customerNames.add("Jokha");
        balances.add(5100.0);
        accountTypes.add("Savings");
        accountStatus.add("Active");

        accountNumbers.add(10006);
        customerNames.add("Hamida");
        balances.add(420.0);
        accountTypes.add("Current");
        accountStatus.add("Closed");

        accountNumbers.add(10007);
        customerNames.add("Nasser");
        balances.add(12000.0);
        accountTypes.add("Savings");
        accountStatus.add("Active");

        accountNumbers.add(10008);
        customerNames.add("Sept");
        balances.add(310.0);
        accountTypes.add("Current");
        accountStatus.add("Active");

        accountNumbers.add(10009);
        customerNames.add("Hamed");
        balances.add(2750.0);
        accountTypes.add("Savings");
        accountStatus.add("Active");

        accountNumbers.add(10010);
        customerNames.add("Nawras");
        balances.add(150.0);
        accountTypes.add("Current");
        accountStatus.add("Suspended");

        //Display Account Information
        for(int i=0; i < accountNumbers.size(); i++){
            //1.  Account index
            System.out.println("Account index: "+i+": ");

            //2. Account number
            System.out.println("Account number: "+accountNumbers.get(i));

            //3. Customer name
            System.out.println("Customer name: "+customerNames.get(i));

            //4. Account type
            System.out.println("Type:  "+accountTypes.get(i));

            //5. Balance
            System.out.println("Balance: "+balances.get(i));

            //6. Status
            System.out.println("Status: "+accountStatus.get(i));
        }

        //Create New Account
        //1. Ask the user for Customer name
        IO.println("Enter Customer name: ");
        String custName = IO.readln();
        //2. Ask the user for Initial balance
        IO.println("Enter Initial balance: ");
        double IntitalBalance = Double.parseDouble(IO.readln());
        //3. Ask the user for Account type
        IO.println("Enter Account type: ");
        String accType = IO.readln();

        if(IntitalBalance<0 || (!accType.equalsIgnoreCase("Savings")&&!accType.equalsIgnoreCase("Current"))){
            System.out.println("The initial number can't be 0");
        }else{
            //Generate a unique account number automatically
            accountNumbers.add(1001+accountNumbers.size());
            //Adding to the array list
            customerNames.add(custName);
            balances.add(IntitalBalance);
            accountTypes.add(accType);
            accountStatus.add("Active");
            System.out.println("Account created successfully");
        }

        //Deposit Money System
        //1. Ask for account number
        IO.println("Enter Account Number: ");
        int depAccNo = Integer.parseInt(IO.readln());

        //2. Search for the account
        int searchIndex = -1;
        for (int i = 0; i < accountNumbers.size(); i++) {
            if (accountNumbers.get(i) == depAccNo) {
                searchIndex = i;
                break;
            }

            if (searchIndex != -1) {
                if (accountStatus.get(searchIndex).equalsIgnoreCase("Active")) {
                    //Ask for deposit amount
                    IO.println("Enter Deposit Amount: ");
                    double depAmount = Double.parseDouble(IO.readln());
                    if (depAmount > 0) {
                        //Add the amount to the current balance
                        double newBalance = balances.get(searchIndex) + depAmount;
                        balances.set(searchIndex, newBalance);
                        System.out.println("Deposit completed successfully!");
                        System.out.println("New Balance: " + newBalance);
                    } else {
                        System.out.println("Invalid deposit amount");
                    }
                } else {
                    System.out.println("Account is not active (" + accountStatus.get(searchIndex) + "), deposit rejected");
                }
            } else {
                System.out.println("Account not found");
            }
        }

        //Withdraw Money System
        //1. Search account by account number
        IO.println("Enter Account Number: ");
        int withAccNum = Integer.parseInt(IO.readln());
        int withIndex = -1;
        for (int i = 0; i < accountNumbers.size(); i++) {
            if (accountNumbers.get(i) == withAccNum) {
                withIndex = i;
                break;
            }
        }

        if (withIndex != -1) {
            if (accountStatus.get(withIndex).equalsIgnoreCase("Active")) {
                //Ask for withdrawal amount
                IO.println("Enter Withdrawal Amount: ");
                double withAmount = Double.parseDouble(IO.readln());
                //Check available balance
                if (withAmount > 0 && withAmount <= balances.get(withIndex)) {
                    double newBalance = balances.get(withIndex) - withAmount;
                    balances.set(withIndex, newBalance);
                    System.out.println("Withdrawal completed successfully!");
                    System.out.println("New Balance: " + newBalance);
                } else if (withAmount > balances.get(withIndex)) {
                    System.out.println("Insufficient funds! Current balance: " + balances.get(withIndex));
                } else {
                    System.out.println("Invalid withdrawal amount.");
                }
            } else {
                System.out.println("Account is not active (" + accountStatus.get(withIndex) + "). Withdrawal rejected.");
            }
        } else {
            System.out.println("Account not found");
        }


        //Transfer Money System
        //1. Sender account number
        IO.println("Enter Sender account number: ");
        int senderAcc = Integer.parseInt(IO.readln());

        //2. Receiver account number
        IO.println("Enter Receiver account number: ");
        int receiverAcc = Integer.parseInt(IO.readln());

        int senderIndex = -1;
        int receiverIndex = -1;

        for (int i = 0; i < accountNumbers.size(); i++) {
            if (accountNumbers.get(i) == senderAcc) {
                senderIndex = i;
            }
            if (accountNumbers.get(i) == receiverAcc) {
                receiverIndex = i;
            }
        }

        if (senderIndex != -1 && receiverIndex != -1) {
            if (!accountStatus.get(senderIndex).equalsIgnoreCase("Active")) {
                System.out.println("Sender account is not active");
            } else if (!accountStatus.get(receiverIndex).equalsIgnoreCase("Active")) {
                System.out.println("Receiver account is not active");
            } else {
                IO.println("Enter Transfer Amount: ");
                double transferAmount = Double.parseDouble(IO.readln());
                //Sender must have enough balance & Amount must be greater than zero &
                if (transferAmount > 0 && transferAmount <= balances.get(senderIndex)) {

                    //Sender Balance = Sender Balance - Amount
                    balances.set(senderIndex, balances.get(senderIndex) - transferAmount);
                    //Receiver Balance = Receiver Balance + Amount
                    balances.set(receiverIndex, balances.get(receiverIndex) + transferAmount);
                    System.out.println("Transfer successful");
                    System.out.println("Sender New Balance: " + balances.get(senderIndex));
                    System.out.println("Recipient New Balance: " + balances.get(receiverIndex));
                } else {
                    System.out.println("Transfer failed! Check amount or insufficient funds");
                }
            }
        } else {
            System.out.println("One or both account numbers are invalid.");
        }

        //Account Search System
        IO.println("Search by: 1) Account Number 2) Customer Name");
        int sreachChoice = Integer.parseInt(IO.readln());
        int foundIndex = -1;

        if(sreachChoice==1){
            IO.println("Enter Account Number: ");
            int targetAcc = Integer.parseInt(IO.readln());
            for(int i=0; i<accountNumbers.size(); i++){
                if(accountNumbers.get(i) == targetAcc){
                    foundIndex = i;
                    break;
                }
            }
        }else{
            IO.println("Enter Customer Name: ");
            String targetName = IO.readln();
            for(int i = 0; i < customerNames.size(); i++){
                if(customerNames.get(i).equalsIgnoreCase(targetName)){
                    foundIndex = i;
                    break;

                }
            }
        }

        if(foundIndex!=-1){
            System.out.println("Account found");
            System.out.println("Account Number: "+accountNumbers.get(foundIndex));
            System.out.println("Cutomer Name: "+customerNames.get(foundIndex));
            System.out.println("Type: "+accountTypes.get(foundIndex));
            System.out.println("Balance: "+balances.get(foundIndex));
            System.out.println("Status: "+accountStatus.get(foundIndex));
        }else{
            System.out.println("Account not found");
        }

        //Banking Statistics Report
        //1. Total number of accounts
        System.out.println("Total Accounts::"+accountNumbers.size());

        //2. Total money stored in all accounts
        double sum = 0;
        for(int i = 0; i<balances.size(); i++){
            sum += balances.get(i);
        }
        System.out.println("Total Balance: "+sum);

        //3. Average account balance
        double average = (double) sum / accountNumbers.size();
        System.out.println("Average Balance: "+average);

        //4. Highest account balance & Lowest account balance
        double totalMoney = 0.0;
        double highestBalance = balances.get(0);
        double lowestBalance = balances.get(0);

        for (int i = 0; i < accountNumbers.size(); i++) {
            double currentBal = balances.get(i);
            totalMoney += currentBal;

            if (currentBal > highestBalance) {
                highestBalance = currentBal;
            }
            if (currentBal < lowestBalance) {
                lowestBalance = currentBal;
            }
        }
        System.out.println("Highest Balance: "+highestBalance);
        System.out.println("Lowest Balance: "+lowestBalance);

        //Account Status Analysis
        int activeAcc = 0;
        int suspendedAcc = 0;
        int closedAcc = 0;

        for (String status: accountStatus){
            if(status.equalsIgnoreCase("Active")){
                activeAcc++;
            } else if (status.equalsIgnoreCase("Suspended")) {
                suspendedAcc++;
            } else if (status.equalsIgnoreCase("Closed")) {
                closedAcc++;
            }
        }
        System.out.println("Active Accounts:"+activeAcc);
        System.out.println("Suspended Accounts:"+suspendedAcc);
        System.out.println("Closed Accounts:"+closedAcc);

        //Update Account Information
        //1. Ask the user for the order index
        IO.println("Please enter the index position: ");
        int index = Integer.parseInt(IO.readln());

        //2. Replace the old bank info with a bank info
        if (index >= 0 && index < accountNumbers.size()) {
            // Allow updating Customer name
            IO.println("New Customer name: ");
            String updatedName = IO.readln();

            // Allow updating Account type
            IO.println("New Account type: ");
            String updatedType = IO.readln();

            //Allow updating Account status
            IO.println("New Account status: ");
            String updateStatus= IO.readln();

            // Set updated values in the ArrayLists
            customerNames.set(index, updatedName);
            accountTypes.set(index, updatedType);
            accountStatus.set(index, updateStatus);

            System.out.println("Account information updated successfully");
        } else {
            System.out.println("Invalid index position");
        }

        //Remove Account
        // 1. Ask for the account index to remove
        IO.println("Please enter the index position to remove: ");
        int removeIndex = Integer.parseInt(IO.readln());

        // 2. Validate index before removing
        if (removeIndex >= 0 && removeIndex < accountNumbers.size()) {
            // Remove related information from all ArrayLists
            accountNumbers.remove(removeIndex);
            customerNames.remove(removeIndex);
            balances.remove(removeIndex);
            accountTypes.remove(removeIndex);
            accountStatus.remove(removeIndex);
            System.out.println("Account removed successfully!");
            // 3. Display updated account list
            for (int i = 0; i < accountNumbers.size(); i++) {
                System.out.println("Index " + i + " | Acc No: " + accountNumbers.get(i)
                        + " | Name: " + customerNames.get(i)
                        + " | Type: " + accountTypes.get(i)
                        + " | Balance: " + balances.get(i)
                        + " | Status: " + accountStatus.get(i));
            }
        } else {
            System.out.println("Invalid index position! No account removed");
        }

        //Sorting Accounts
        System.out.println("Sort by: 1) Bal (Low-High) 2) Bal (High-Low) 3) Name (A-Z)");
        int choice = Integer.parseInt(IO.readln());

        for (int i = 0; i < accountNumbers.size() - 1; i++) {
            for (int j = 0; j < accountNumbers.size() - i - 1; j++) {
                boolean swap = (choice == 1 && balances.get(j) > balances.get(j + 1)) ||
                        (choice == 2 && balances.get(j) < balances.get(j + 1)) ||
                        (choice == 3 && customerNames.get(j).compareToIgnoreCase(customerNames.get(j + 1)) > 0);

                if (swap) {
                    accountNumbers.set(j, accountNumbers.set(j + 1, accountNumbers.get(j)));
                    customerNames.set(j, customerNames.set(j + 1, customerNames.get(j)));
                    balances.set(j, balances.set(j + 1, balances.get(j)));
                    accountTypes.set(j, accountTypes.set(j + 1, accountTypes.get(j)));
                    accountStatus.set(j, accountStatus.set(j + 1, accountStatus.get(j)));
                }
            }
        }

        // Display Sorted Accounts
        for (int i = 0; i < accountNumbers.size(); i++) {
            System.out.println(accountNumbers.get(i) + " | " + customerNames.get(i) + " | " + accountTypes.get(i) + " | " + balances.get(i) + " | " + accountStatus.get(i));
        }

    }
}

