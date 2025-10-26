import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Generating a Password...\n Please enter the password length: ");
        int length = scanner.nextInt();

        PasswordGenerator generator = new PasswordGenerator(length);
        System.out.println(PasswordGenerator.generate());   //PlaceHolder Method call
    }
}