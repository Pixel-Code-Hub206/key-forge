import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PasswordGenerator {

    public String generate(){

        short length = 0;
        boolean addNumbers;         //Flag for the future to include NUMBERS over user request
        boolean addSymbols;         //Flag for the future to include SYMBOLS

        Scanner scanner = new Scanner(System.in);
        SecureRandom secureRandom = new SecureRandom();       //Instantiating Secure-Random for better under-the-hood protection through non-deterministic outputs


        while(length < 5)           //Giving a mandatory length requirement for the password to avoid logic conflict in future
        {
            System.out.print("Enter desired length(e.g., 12): ");
            length = scanner.nextShort();
            if(length < 5){
                System.out.println("Password length must be at least 5 characters long to include all requested types");
            }
        }

        scanner.nextLine();

        System.out.print("Include numbers? (y/n): ");
        addNumbers = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include Symbols? (y/n): ");
        addSymbols = scanner.nextLine().equalsIgnoreCase("y");

        //Pool of characters according to user preference
        final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";        //Take LOWERCASE_CHARS + UPPERCASE_CHARS as the default
        final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String NUMBERS = "0123456789";
        final String SYMBOLS = "!@#$%^&*_=+-/";
        StringBuilder characterPool = new StringBuilder(LOWERCASE_CHARS + UPPERCASE_CHARS);    //Collection of Base letters

        ArrayList<Character> passwordChars = new ArrayList<>();         //The password to be generated

        passwordChars.add(LOWERCASE_CHARS.charAt(secureRandom.nextInt(LOWERCASE_CHARS.length())));      //Adding 1 mandatory lowercase letter
        passwordChars.add(UPPERCASE_CHARS.charAt(secureRandom.nextInt(UPPERCASE_CHARS.length())));      //Adding 1 mandatory uppercase letter
        int mandatory = 2;

        if(addNumbers){
            passwordChars.add(NUMBERS.charAt(secureRandom.nextInt(NUMBERS.length())));      //Adding 1 mandatory
            characterPool.append(NUMBERS);
            mandatory++;
        }
        if(addSymbols) {
            passwordChars.add(SYMBOLS.charAt(secureRandom.nextInt(SYMBOLS.length())));
            characterPool.append(SYMBOLS);
            mandatory++;
        }

        for(int i = 0; i < length - mandatory; i++)     //length - (already selected 'mandatory' characters)
        {
            int randIndex = secureRandom.nextInt(characterPool.length());     //The actual password generation(for the remaining characters)
            char randChar = characterPool.charAt(randIndex);
            passwordChars.add(randChar);
        }

        Collections.shuffle(passwordChars, secureRandom);

        StringBuilder finalPassword = new StringBuilder();

        for(char c : passwordChars){                        //Array to StringBuilder to String
            finalPassword.append(c);
        }

        return finalPassword.toString();     //The Final generated password to be returned
    }
}
