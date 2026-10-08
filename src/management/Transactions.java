package management;

import validate.Validations;

import java.io.*;
import java.util.ArrayList;

public class Transactions {

    //Deposits the money then updates the file
    public static int deposit(String serialNumber, String depositedAmount, int transfer) {
        double depositAmount = Double.parseDouble(depositedAmount);

        if (depositAmount == 0) {
            return -1;
        }
        if (depositAmount > 10000) {
            return -2;
        }

        ArrayList<String> accountsFromFile = Validations.accountsFileReader();
        String line;
        String[] account;

        int accountFound = 0;

        if (!accountsFromFile.isEmpty()) {
            for (int i = 0; i < accountsFromFile.size(); i++) {
                line = accountsFromFile.get(i);
                account = line.split(",");
                String serial = account[0];

                if (serial.equals(serialNumber)) {
                    accountFound = 1;
                    String username = account[1];
                    String email = account[2];
                    String balanceString = account[3];
                    String phone = account[4];
                    String date = account[5];
                    String type = account[6];

                    depositAmount = Double.parseDouble(depositedAmount);
                    double balance = Double.parseDouble(balanceString);

                    balance = balance + depositAmount;

                    balanceString = String.format("%.2f", balance);
                    String updatedAccount = serial + "," + username + "," + email + "," + balanceString + "," + phone + "," + date + "," + type;

                    accountsFromFile.set(i, updatedAccount);
                    String transaction = "";
                    if (transfer == 0)
                        transaction = serialNumber + ",deposit," + depositedAmount + "," + Validations.Date() + ",deposit " + depositedAmount + "\n";

                    recordTransaction(serialNumber, transaction);
                }
                if (accountFound == 1) {
                    break;
                }
            }

            if (accountFound == 1) {

                File accounts = new File("DB\\accounts.txt");


                try (BufferedWriter writer = new BufferedWriter(new FileWriter(accounts))) {
                    for (String accountEntry : accountsFromFile) {
                        writer.write(accountEntry);
                        writer.newLine();
                    }

                } catch (IOException e) {
                }
            }
        }
        return accountFound;
    }


    //Withdraw money from an account then updates the file
    public static int withdraw(String serialNumber, String withdrawalAmount, String methodType) {

        ArrayList<String> accountsFromFile = Validations.accountsFileReader();

        String line;


        String[] account;

        double withdrawnAmount = Double.parseDouble(withdrawalAmount);

        if (withdrawnAmount == 0) {
            return -4;
        }
        if (withdrawnAmount > 10000) {
            return -2;
        }

        int accountFound = 0;

        if (!accountsFromFile.isEmpty()) {

            for (int i = 0; i < accountsFromFile.size(); i++) {

                line = accountsFromFile.get(i);

                account = line.split(",");

                String serial = account[0];


                if (serial.equals(serialNumber)) {

                    accountFound = 1;

                    String username = account[1];

                    String email = account[2];

                    String balanceString = account[3];

                    String phone = account[4];

                    String date = account[5];

                    String type = account[6];

                    double balance = Double.parseDouble(balanceString);

                    if (balance == 0)
                        return -4;

                    if (methodType.equalsIgnoreCase("Transfer")) {
                        if (type.equals("Current"))
                            balance = balance - 10;
                    }

                    if (methodType.equalsIgnoreCase("Withdraw")) {
                        if (type.equals("Current") && withdrawnAmount < 1000) {

                            if ((balance - 10) < withdrawnAmount)
                                return -3;

                            if (balance > 10)
                                balance = balance - 10;
                            else if (balance <= 10)
                                return -3;
                        }
                    }

                    if (balance < Double.parseDouble(withdrawalAmount)) {
                        return -1;
                    } else
                        balance -= Double.parseDouble(withdrawalAmount);

                    balanceString = String.format("%.2f", balance);

                    String updatedAccount = serial + "," + username + "," + email + "," + balanceString + "," + phone + "," + date + "," + type;
                    String transaction = "";

                    if (methodType.equalsIgnoreCase("Withdraw"))
                        transaction = serialNumber + ",Withdraw," + withdrawalAmount + "," + Validations.Date() + "," + "Withdrawn " + withdrawalAmount + "\n";

                    recordTransaction(serialNumber, transaction);

                    accountsFromFile.set(i, updatedAccount);

                    System.out.println(updatedAccount);

                    System.out.println(accountsFromFile);
                }
            }

            if (accountFound == 1) {

                File accounts = new File("DB\\accounts.txt");


                try (BufferedWriter writer = new BufferedWriter(new FileWriter(accounts))) {

                    for (String accountEntry : accountsFromFile) {

                        writer.write(accountEntry);

                        writer.newLine();

                    }


                } catch (IOException e) {

                    System.out.println("An error occurred while updating the file: " + e.getMessage());

                }
            }
        }

        return accountFound;
    }

    public static int transfer(String withdrawnFrom, String sentTo, String amount) {
        int warning = withdraw(withdrawnFrom, amount, "Transfer");
        if (warning == 1) {
            deposit(sentTo, amount , 1);

            String transaction1 = withdrawnFrom + ",Transfer," + amount + "," + Validations.Date() + "," + "Transferred " + amount + " to account " + sentTo;
            String transaction2 = sentTo + ",Received," + amount + "," + Validations.Date() + "," + "Received " + amount + " from account " + withdrawnFrom;

            recordTransaction(withdrawnFrom, transaction1);
            recordTransaction(sentTo, transaction2);
        }
        return warning;
    }

    //Checks if an account has a transaction history
    public static boolean hasTransactionHistory(String serialNumber) {
        String fileName = serialNumber + ".txt";
        File transactionFile = new File("DB" + File.separator + fileName);

        if (!transactionFile.exists()) {
            System.out.println("No transaction history found for account: " + serialNumber);
            return false;
        }
        return true;
    }

    //Views all the transaction history
    public static ArrayList<String[]> viewTransactionHistory() {

        ArrayList<String> serialNumbers = new ArrayList<>();
        ArrayList<String[]> transactions = new ArrayList<>();

        for (int i = 0; i < Validations.accountsFileReader().size(); i++) {
            serialNumbers.add(Validations.accountsFileReader().get(i).split(",")[0]);
        }


        for (int i = 0; i < serialNumbers.size(); i++) {

            if (hasTransactionHistory(serialNumbers.get(i))) {
                String fileName = serialNumbers.get(i) + ".txt";
                File transactionFile = new File("DB" + File.separator + fileName);


                try (BufferedReader reader = new BufferedReader(new FileReader(transactionFile))) {
                    String transaction;

                    while ((transaction = reader.readLine()) != null) {
                        transactions.add(transaction.split(","));
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred while reading the transaction history: " + e.getMessage());
                }
            }
        }
        return transactions;
    }

    //Views a specific transaction history one serial number
    public static ArrayList<String[]> viewTransactionHistory(String serialNumber) {

        ArrayList<String[]> transactions = new ArrayList<>();


        if (hasTransactionHistory(serialNumber)) {
            String fileName = serialNumber + ".txt";
            File transactionFile = new File("DB" + File.separator + fileName);


            try (BufferedReader reader = new BufferedReader(new FileReader(transactionFile))) {
                String transaction;

                while ((transaction = reader.readLine()) != null) {
                    transactions.add(transaction.split(","));
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading the transaction history: " + e.getMessage());
            }
        }

        return transactions;
    }

    //Writes the transaction to the file
    public static void recordTransaction(String serialNumber, String transactionDetails) {
        String fileName = serialNumber + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DB" + File.separator + fileName, true))) {
            writer.write(transactionDetails);

        } catch (IOException e) {
            System.out.println("Error recording transaction: " + e.getMessage());
        }
    }

}