package management;

import validate.Validations;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import static management.Transactions.recordTransaction;

public class Accounts {


    //Generates a serial number for each account
    private static long serialNumber() {
        Random rand = new Random();
        long serialNumber;
        String serialNumberStr;

        do {
            serialNumber = Math.abs(rand.nextLong());

            serialNumberStr = String.valueOf(serialNumber);

            if (serialNumberStr.length() > 10) {
                serialNumberStr = serialNumberStr.substring(0, 10);
            }
        } while (Validations.serialNumberExists(serialNumberStr));

        return Long.parseLong(serialNumberStr);
    }


    //Adds the account to the file
    public static void addAccount(String username, String email, String phone, String type) {

        File accounts = new File("DB\\accounts.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(accounts, true))) {
            writer.write(serialNumber() + "," + username + "," + email + "," + "0.00" + "," + phone + "," + Validations.Date() + "," + type + "\n");

        } catch (IOException e) {
            System.out.println("File not found!");
        }

    }


    //Closes the account
    public static boolean closeAccount(String serialNumber) {
        ArrayList<String> accountsFromFile = Validations.accountsFileReader();

        boolean deleted = false;
        if (!accountsFromFile.isEmpty()) {

            if (Validations.balanceZero(serialNumber)) {
                String line;
                String[] account;

                for (int i = 0; i < accountsFromFile.size(); i++) {
                    line = accountsFromFile.get(i);

                    account = line.split(",");

                    String serial = account[0];

                    if (serial.equals(serialNumber)) {
                        accountsFromFile.remove(i);

                        String file = serial + ".txt";
                        File acc = new File("DB\\" + file);

                        if (acc.exists())
                            acc.delete();

                        deleted = true;
                    }
                }
            }

            File accounts = new File("DB\\accounts.txt");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(accounts, false))) {


                for (String s : accountsFromFile) {

                    writer.write(s);
                    writer.newLine();

                }


            } catch (IOException e) {
                System.out.println("File not found!");
            }
        }
        return deleted;
    }

    //Modifies the account
    public static void modifyAccount(String serialNumber, String username, String email, String phone) {
        ArrayList<String> accountsFromFile = Validations.accountsFileReader();
        String line;
        String[] account;


        if (!accountsFromFile.isEmpty()) {
            for (int i = 0; i < accountsFromFile.size(); i++) {
                line = accountsFromFile.get(i);
                account = line.split(",");
                String serial = account[0];

                if (serial.equals(serialNumber)) {

                    String balance = account[3];
                    String date = account[5];
                    String type = account[6];

                    String updatedAccount = serial + "," + username + "," + email + "," + balance + "," + phone + "," + date + "," + type;

                    accountsFromFile.set(i, updatedAccount);
                    break;
                }
            }


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


    //Applies interest to customers with current account each 4 months
    public static int applyInterest() {
        ArrayList<String> accountsFromFile = Validations.accountsFileReader();
        String line;
        String[] account;

        int accountsUpdated = 0;

        if (!accountsFromFile.isEmpty()) {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate currDate = LocalDate.now();
            String currentDate = currDate.format(dateFormatter);

            LocalDate today = LocalDate.parse(currentDate, dateFormatter);

            for (int i = 0; i < accountsFromFile.size(); i++) {
                line = accountsFromFile.get(i);
                account = line.split(",");

                String serial = account[0];
                String username = account[1];
                String email = account[2];
                String balanceString = account[3];
                String phone = account[4];
                String date = account[5];
                String type = account[6];

                if (type.equalsIgnoreCase("Savings")) {
                    try {
                        LocalDate activationDate = LocalDate.parse(date, dateFormatter);

                        Period difference = Period.between(activationDate, today);

                        int monthsActive = difference.getMonths();
                        int yearsActive  = difference.getYears();


                        if (monthsActive >= 4 || yearsActive >= 1) {
                            double balance = Double.parseDouble(balanceString);
                            balance += balance * 0.05;

                            balanceString = String.format("%.2f", balance);

                            String updatedAccount = serial + "," + username + "," + email + "," + balanceString + ","
                                    + phone + "," + date + "," + type;

                            accountsFromFile.set(i, updatedAccount);
                            accountsUpdated++;
                        }
                    } catch (Exception e) {
                        System.out.println("Error parsing date for account: " + serial);
                    }
                }
            }

            if (accountsUpdated > 0) {
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

        return accountsUpdated;
    }


    //Reads and splits account details of each customer from the file into an array list
    public static ArrayList<String[]> viewAccounts() {

        ArrayList<String[]> accountsData = new ArrayList<>();

        File accountsFile = new File("DB\\accounts.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(accountsFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] accountDetails = line.split(",");
                accountsData.add(accountDetails);
            }

        } catch (IOException e) {
            System.out.println("File not found!");
        }

        return accountsData;
    }

    //Searches in accounts for a name
    public static ArrayList<String[]> searchAccounts(String keyword) {
        ArrayList<String> accountsFromFile = Validations.accountsFileReader();
        ArrayList<String[]> matchedAccounts = new ArrayList<>();

        if (!accountsFromFile.isEmpty()) {
            for (String account : accountsFromFile) {
                String[] accountDetails = account.split(",");
                String username = accountDetails[1];
                if (username.toLowerCase().trim().contains(keyword.toLowerCase().trim())) {
                    matchedAccounts.add(accountDetails);
                }
            }
        }

        return matchedAccounts;
    }

    //Sorts the accounts according to the user choice
    public static ArrayList<String[]> sortAccounts(String sortBy) {

        //Reads from the file
        ArrayList<String> accounts = Validations.accountsFileReader();

        //Holds the sorted accounts
        ArrayList<String[]> sortedAccounts = new ArrayList<>();

        if (!accounts.isEmpty()) {

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            boolean swapped;


            //Bubble sort
            for (int i = 0; i < accounts.size() - 1; i++) {
                swapped = false;
                for (int j = 0; j < accounts.size() - i - 1; j++) {

                    //Places the data of two accounts into an array
                    String[] account1 = accounts.get(j).split(",");
                    String[] account2 = accounts.get(j + 1).split(",");

                    //Checks if the accounts needs to be swapped
                    boolean swapping = false;


                    switch (sortBy.toLowerCase()) {

                        case "name":
                            String name1 = account1[1];
                            String name2 = account2[1];
                            if (name1.compareToIgnoreCase(name2) > 0) {
                                swapping = true;
                            }
                            break;

                        case "balance":
                            double balance1 = Double.parseDouble(account1[3]);
                            double balance2 = Double.parseDouble(account2[3]);
                            if (balance1 < balance2) {
                                swapping = true;
                            }
                            break;

                        case "creation date":
                            try {
                                Date date1 = dateFormat.parse(account1[5]);
                                Date date2 = dateFormat.parse(account2[5]);
                                if (date1.before(date2)) {
                                    swapping = true;
                                }
                            } catch (ParseException e) {
                                System.out.println("Error parsing dates");
                            }
                            break;

                        default:
                            return sortedAccounts;
                    }

                    if (swapping) {

                        String temp = accounts.get(j);
                        accounts.set(j, accounts.get(j + 1));
                        accounts.set(j + 1, temp);
                        swapped = true;


                    }
                }

                //Checks if swapping occurred to keep sorting
                if (!swapped) {
                    break;
                }
            }
        }


        //After sorting puts the sorted result into a String array array list
        for (String account : accounts) {
            String[] accountDetails = account.split(",");
            sortedAccounts.add(accountDetails);

        }

        return sortedAccounts;
    }


}
