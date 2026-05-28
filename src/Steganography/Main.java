package textsteganographysystem;
import java.util.Scanner;
import java.io.*;

public class TextSteganographySystem {

    // Encode Message Method
    public static void encodeMessage(String coverText,String secretMessage) {

        try {
                      FileWriter fw = new FileWriter("encoded.txt");

            fw.write("COVER TEXT\n");
            fw.write(coverText);

            fw.write("\n\n===== HIDDEN MESSAGE =====\n");
            fw.write(secretMessage);
            fw.close();

            System.out.println("Message encoded successfully!");
            System.out.println("Encoded file saved as encoded.txt");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }

    // Decode Message Method
    public static void decodeMessage() {
        try {
             BufferedReader br = new BufferedReader(new FileReader("encoded.txt"));
            String line;
            System.out.println("\n===== DECODED FILE CONTENT =====");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
             System.out.println("Error reading file.");
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== TEXT STEGANOGRAPHY SYSTEM =====");
            System.out.println("1. Encode Message");
            System.out.println("2. Decode Message");
            System.out.println("3. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Cover Text: ");
                    String coverText =
                            sc.nextLine();
                    System.out.print( "Enter Secret Message: ");
                    String secretMessage =
                            sc.nextLine();     
                    encodeMessage(coverText,secretMessage);
                   
   System.out.println("Visible content remains unchanged.");
                    break;
                case 2:
                decodeMessage();
                    break;
                    case 3:
                  System.out.println("Exiting Program...");
                    break;
                     default:
             System.out.println("Invalid Choice.");
            }

        } 
        while (choice != 3);
          sc.close();
    }
}