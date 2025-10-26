import java.util.Random;

public class PasswordGenerator {

    static int length;

    PasswordGenerator(int length){      //Constructor to define the parameters of the password generator
        PasswordGenerator.length = length;
    }

    public static String generate(){

        String characterCollection = "abcdefghijklmnopqrstuvwxyz!@#$&=ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder password = new StringBuilder();
        Random random = new Random();       //Instantiating the object to call all its methods

        for(int i = 0; i < length; i++)
        {
            int randIndex = random.nextInt(characterCollection.length());
            char randChar = characterCollection.charAt(randIndex);
            password.append(randChar);
        }
        return password.toString();
    }
}
