package Midterm;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class EncryptFileHandlingToribio {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        try (FileWriter myWriter = new FileWriter("C:\\\\Users\\\\Eunace Faith Emactao\\\\OneDrive\\\\Desktop\\\\ToribioInput.txt")) {
            myWriter.write("I love you!\nGwapa ko!\nBuotan si Ma'am.");
        }

        File myFile = new File("C:\\\\Users\\\\Eunace Faith Emactao\\\\OneDrive\\\\Desktop\\\\ToribioInput.txt");
        Scanner in = new Scanner(myFile);

        System.out.println("Encrypted Message:");
        while (in.hasNextLine()) {
            String data = in.nextLine();
            int key = 6;
            String message = data;
            String encryptedMessage = encryptMessage(message, key);
            System.out.println(encryptedMessage);

            try (FileWriter myWriter = new FileWriter("C:\\\\Users\\\\Eunace Faith Emactao\\\\OneDrive\\\\Desktop\\\\ToribioEncrypted.txt", true)) {
                myWriter.write(encryptedMessage + "\n");
        }
    }}

    public static String encryptMessage(String message, int key) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] += key;
        }
        return new String(chars);

    }
        
    }

