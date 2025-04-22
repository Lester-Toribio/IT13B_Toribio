
package Midterm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OrderingSystem {

    static final String GWAPO = "C:\\Users\\Eunace Faith Emactao\\OneDrive\\Desktop\\Gwapo.txt";
    static final int KEY = 3;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean tao = true;

        while (tao) {
            System.out.println("MANGAON TA YA");
            System.out.println("1 - LOG IN\n2 - Create Account");
            System.out.print("Enter choice: ");

            int choice = in.nextInt();
            in.nextLine(); 

            if (choice == 1) {
              
                login(in);
            } else if (choice == 2) {
                createAccount(in);
            } else {
                System.out.println("Invalid choice");
            }

        }
        in.close(); 
    }

    public static void createAccount(Scanner in) {
        System.out.println("Create new account");
        System.out.print("Enter Username: ");
        String username = in.nextLine();

        System.out.print("Enter Password: ");
        String password = in.nextLine();

        String encryptedPassword = passwordEncryption(password, KEY);

        try (FileWriter myWriter = new FileWriter(GWAPO, true)) {
            myWriter.write(username + "," + encryptedPassword + "\n");
            System.out.println("Account created successfully!");
        } catch (IOException e) {
            System.out.println("Error saving account.");
            e.printStackTrace();
        }
    }

    public static void login(Scanner in) {
        System.out.print("Enter Username: ");
        String username = in.nextLine();

        System.out.print("Enter Password: ");
        String password = in.nextLine();

        String encryptedPassword = passwordEncryption(password, KEY);
        boolean success = false;

        try {
            File file = new File(GWAPO);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String storedUsername = parts[0];
                    String storedPassword = parts[1];
                    if (username.equals(storedUsername) && encryptedPassword.equals(storedPassword)) {
                        success = true;
                        break;
                    }
                }
            }

            fileScanner.close();

            if (success) {
                System.out.println("✅ Login successful. Welcome back, " + username + "!");
                whiteyToribio(in);  
            } else {
                System.out.println("❌ Invalid username or password.");
            }

        } catch (IOException e) {
            System.out.println("❌ Error reading account file.");
            e.printStackTrace();
        }
    }

    public static String passwordEncryption(String password, int key) {
        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] += key;
        }
        return new String(chars);
    }

    public static void whiteyToribio(Scanner in) {
        String[] menuItems = {"Taco", "Quesadillas", "Soda"};
        int[] prices = {120, 150, 40};
        int[] quantities = new int[menuItems.length];

        int choice;
        do {
            System.out.println("\n--- MENU ---");
            for (int i = 0; i < menuItems.length; i++) {
                System.out.println((i + 1) + ". " + menuItems[i] + " - ₱" + prices[i]);
            }
            System.out.println("4. Exit");

            System.out.print("Choose an item to order (1-4): ");
            choice = in.nextInt();

            if (choice >= 1 && choice <= 3) {
                System.out.print("Enter quantity for " + menuItems[choice - 1] + ": ");
                int qty = in.nextInt();
                if (qty > 0) {
                    quantities[choice - 1] += qty;
                    System.out.println(qty + " " + menuItems[choice - 1] + "(s) added to your order.");
                } else {
                    System.out.println("Please enter a valid quantity.");
                }
            } else if (choice != 4) {
                System.out.println("Invalid choice, please try again.");
            }

        } while (choice != 4); 

        System.out.println("\n--- ORDER SUMMARY ---");
        int total = 0;
        for (int i = 0; i < menuItems.length; i++) {
            if (quantities[i] > 0) {
                int itemTotal = prices[i] * quantities[i];
                System.out.println(menuItems[i] + " x " + quantities[i] + " = ₱" + itemTotal);
                total += itemTotal;
            }
        }

        System.out.println("Total Bill: ₱" + total);
        System.out.println("Thank you for your order!");
    }
}
