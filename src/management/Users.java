package management;

import java.io.*;

public class Users {

    //Checks if the user exists in the database
    public static boolean isUser(String username, String password) {

        File users = new File( "DB\\users.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(users))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userAndPass = line.split(" ");

                if(isFound(username, password, userAndPass))
                    return true;
            }

        } catch (IOException e) {
            System.out.println("File not found!");
        }
        return false;
    }

    //Helper method for the isUser method
    private static boolean isFound(String username, String password, String[] userAndPass) {

        String user = userAndPass[0];
        String pass = userAndPass[1];

        return user.equals(username) && pass.equals(password);
    }
}
