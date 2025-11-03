import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    public void generate(){

        String label;
        short length;
        boolean addNumbers;         //Flag for the future to include numbers over user request
        boolean addSymbols;         //Flag for the future to include symbols
        boolean save;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a label for this password(e.g., gmail): ");
        label = scanner.nextLine().toLowerCase();

        System.out.print("Enter desired length(e.g., 12): ");
        length = scanner.nextShort();

        System.out.print("Include numbers? (y/n): ");
        addNumbers = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include Symbols? (y/n): ");
        addSymbols = scanner.nextLine().equalsIgnoreCase("y");

        //Pool of characters according to user preference
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/";
        String characterCollection = "abcdefghijklmnopqrstuvwxyz!@#$&=ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";    //Temporary joint character collection for testing

        StringBuilder password = new StringBuilder();
        Random random = new Random();       //Instantiating the object to call all its methods

        for(int i = 0; i < length; i++)
        {
            int randIndex = random.nextInt(characterCollection.length());
            char randChar = characterCollection.charAt(randIndex);
            password.append(randChar);
        }

        System.out.println("Generated Password: "+password.toString());
        System.out.println("Would you like to save it? (y/n): ");
        save = scanner.nextLine().equalsIgnoreCase("y");        //True if user enter "Y" or "y", otherwise false
    }
}
