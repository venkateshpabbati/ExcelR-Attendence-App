import java.util.Scanner;

public class AdditionWithScanner {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter two numbers
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();  // Read first number

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();  // Read second number

        // Compute the sum
        int sum = num1 + num2;

        // Display the result
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);

        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Scanner;

public class SecureLogin {
    // Simulated database (Username -> Hashed Password)
    private static HashMap<String, String> usersDB = new HashMap<>();

    public static void main(String[] args) {
        // Sample user registration (Username: admin, Password: password123)
        usersDB.put("admin", hashPassword("password123"));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (authenticate(username, password)) {
            System.out.println("Login Successful! Welcome, " + username);
        } else {
            System.out.println("Invalid Username or Password. Access Denied!");
        }

        scanner.close();
    }

    // Password hashing using SHA-256
    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b)); // Convert bytes to hex
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    // Authenticate user by checking the hashed password
    private static boolean authenticate(String username, String password) {
        if (usersDB.containsKey(username)) {
            return usersDB.get(username).equals(hashPassword(password));
        }
        return false;
    }
}
