import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    public void generate(){

        String label;
        short length;
        boolean addNumbers;         //Flag for the future to include numbers over user request
        boolean addSymbols;         //Flag for the future to include symbols
        String flag;
        String flag2;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a label for this password(e.g., gmail): ");
        label = scanner.nextLine().toLowerCase();

        System.out.print("Enter desired length(e.g., 12): ");
        length = scanner.nextShort();

        System.out.print("Include numbers? (y/n): ");
        flag = scanner.next().toLowerCase();
        if(flag.equals("y"))
        {
            System.out.println("Including Numbers");
            addNumbers = true;
        }
        else {
            System.out.println("No numbers.");
            addNumbers = false;
        }

        System.out.print("Include Symbols? (y/n): ");
        flag2 = scanner.next().toLowerCase();
        if(flag2.equals("y"))
        {
            System.out.println("Including Symbols");
            addSymbols = true;
        }
        else {
            System.out.println("No Symbols.");
            addSymbols = false;
        }

        String characterCollection = "abcdefghijklmnopqrstuvwxyz!@#$&=ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

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
        String saveFlag = scanner.next();
    }
}
