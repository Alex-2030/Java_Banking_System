package validate;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Validations {

    //Validate if the input is made of letters and a full name
    public static boolean isFullName(String fullName) {
        fullName = fullName.trim();


        int indexOfSpace = fullName.indexOf(' ');
        int spaceCounter = 0;

        if (fullName.isEmpty()) {
//            System.out.println("Please enter a name!");
            return false;
        }

        if (indexOfSpace == -1) {
//            System.out.println("Please enter your full name!");
            return false;
        }

        for (int j = 0; j < fullName.length(); j++) {

            indexOfSpace = fullName.indexOf(' ', j);


            if (indexOfSpace != -1 && j == indexOfSpace) {
                spaceCounter++;
                continue;
            }

            if (!Character.isLetter(fullName.charAt(j))) {
//                System.out.println("Please enter a valid word!");
                return false;
            }

            if (spaceCounter >= 2) {
//                System.out.println("Please enter your name and surname only!");
                return false;
            }

        }

        return true;
    }

    //Validate username with dot delimiter
    public static boolean isUserName(String string) {
        string = string.trim();

        int indexOfDot = string.indexOf('.');
        int dotCounter = 0;

        if (string.isEmpty()) {
//            System.out.println("Please enter a username!");
            return false;
        }

        if (indexOfDot == -1) {
//            System.out.println("Please enter your username!");
            return false;
        }

        for (int j = 0; j < string.length(); j++) {

            indexOfDot = string.indexOf('.', j);


            if (indexOfDot != -1 && (j) == indexOfDot) {
                dotCounter++;
                continue;
            }

            if (!Character.isLetter(string.charAt(j))) {

//                System.out.println("Invalid username!");
                return false;
            }

            if (dotCounter >= 2) {
//                System.out.println("Invalid username!");
                return false;
            }

        }

        return true;
    }

    public static boolean isLetter(String string) {
        string = string.trim();

        if (string.isEmpty()) {
//            System.out.println("Please enter a word!");
            return false;
        }

        for (int i = 0; i < string.length(); i++) {

            if (!Character.isLetter(string.charAt(i)) && string.charAt(i) != ' ') {
//                System.out.println("Please enter a valid word!");
                return false;
            }
        }

        return true;
    }

    //Validate if the input is digit
    public static boolean isDigit(String string) {
        string = string.trim();


        if (string.isEmpty()) {
//            System.out.println("Please enter a number!");
            return false;
        }

        for (int j = 0; j < string.length(); j++) {

            if (!Character.isDigit(string.charAt(j))) {
//                System.out.println("Invalid number!");
                return false;
            }
        }
        return true;
    }

    //Validate if the input is digit
    public static boolean isDoubleDigit(String string) {
        string = string.trim();


        if (string.isEmpty()) {
            System.out.println("Please enter a number!");
            return false;
        }

        int indexOfDot = string.indexOf('.');

        for (int j = 0; j < string.length(); j++) {

            if (indexOfDot != -1 && j == indexOfDot) {
                continue;
            }
            if (!Character.isDigit(string.charAt(j))) {
                System.out.println("Invalid number!");
                return false;
            }
        }
        return true;
    }


    public static int isEmail(String email) {
        email = email.trim();

        ArrayList<String> accounts = accountsFileReader();

        String line;
        String[] account;
        if (!accounts.isEmpty()) {
            for (String s : accounts) {
                line = s;

                account = line.split(",");

                String emailFromFile = account[2];

                if (email.equals(emailFromFile)) {
                    return -1;
                }
            }
        }

        if (email.isEmpty()) {
//            System.out.println("Please enter a valid email address!");
            return 0;
        }

        String regex = "^[a-zA-Z0-9._]+@[a-zA-Z]+\\.com$";

        if (!email.matches(regex)) {
//            System.out.println("Invalid email address!");
            return 0;
        }

        return 1;
    }

    public static int isPhone(String phone) {

        ArrayList<String> accounts = accountsFileReader();

        String line;
        String[] account;

        if (!accounts.isEmpty()) {
            for (String s : accounts) {
                line = s;

                account = line.split(",");

                String phoneFromFile = account[4];

                if (phone.equals(phoneFromFile)) {
                    return -1;
                }
            }
        }

        if ((phone.length() != 11) || (phone.charAt(0) != '0')) {
//            System.out.println("Please enter a valid phone number!");
            return 0;
        }

        if (!isDigit(phone)) {
            return 0;
        }

        return 1;
    }

    //Gets the current date of the day from the system
    public static String Date() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }


    public static boolean serialNumberExists(String serial) {
        ArrayList<String> accounts = accountsFileReader();

        String line;
        String[] account;
        if (!accounts.isEmpty()) {
            for (String s : accounts) {
                line = s;

                account = line.split(",");

                String serialFromFile = account[0];

                if (serial.equals(serialFromFile)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean balanceZero(String serialNumber) {
        ArrayList<String> accounts = accountsFileReader();

        String[] account;
        if (!accounts.isEmpty()) {
            for (String line : accounts) {

                account = line.split(",");
                if (serialNumber.equals(account[0])) {

                    String balanceFromFile = account[3];
                    double balance = Double.parseDouble(balanceFromFile);

                    if (balance == 0)
                        return true;
                }
            }

        }
        return false;
    }

    public static ArrayList<String> accountsFileReader() {

        ArrayList<String> accounts = new ArrayList<>();

        File users = new File("DB\\accounts.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(users))) {
            String line;
            while ((line = reader.readLine()) != null) {
                accounts.add(line);
            }

        } catch (IOException e) {
            System.out.println("File not found!");
        }
        return accounts;
    }

}
