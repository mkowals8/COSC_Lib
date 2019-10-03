package textfiles.kowalski_michael;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * ReadData
 */
public class ReadData {

    public static void main(String[] args) throws Exception {
        File file = openFile("scores.txt");
        try (
                // Create a Scanner for the file
                Scanner input = new Scanner(file, StandardCharsets.UTF_8);) {
            // Read data from a file
            while (input.hasNext()) {
                String firstName = input.next();
                String mi = input.next();
                String lastName = input.next();
                int score = input.nextInt();
                System.out.println(firstName + " " + mi + " " + lastName + " " + score);
            }
        }
    }

    private static File openFile(String _filename) throws FileNotFoundException {
        // Create a File instance
        java.io.File file = new java.io.File(_filename);
        return file;
    }
}
