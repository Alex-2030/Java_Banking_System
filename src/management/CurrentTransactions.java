package management;

import validate.Validations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static management.Transactions.recordTransaction;

public class CurrentTransactions extends BaseTrasnactions {

    public static String accType(String serialNumber) {
        String type = "";
        if (Validations.serialNumberExists(serialNumber)) ;
        {
            ArrayList<String> accounts = Validations.accountsFileReader();

            for (int i = 0; i < accounts.size(); i++) {
                String[] details = accounts.get(i).split(",");
                if (serialNumber.equals(details[0])) {
                    type = details[6];
                }
            }
        }
        return type;
    }

    @Override
    public int withdraw(String serialNumber, String withdrawalAmount, String methodType) {
        //Withdraw money from an account then updates the file

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
                        if (withdrawnAmount < 1000) {

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

}

