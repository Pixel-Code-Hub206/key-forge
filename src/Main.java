import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        byte choice;

       do {
           System.out.println("===================================");
           System.out.println("\t \uD83D\uDD12 WELCOME TO KEYFORGE \uD83D\uDD12");
           System.out.println("Your Personal Local Password Vault");
           System.out.println("===================================");

           System.out.println("[1] Generate a New Password");
           System.out.println("[2] Add an Existing Password");
           System.out.println("[3] View all Saved Password");
           System.out.println("[4] Delete a Saved Password");
           System.out.println("[5] Exit");
           System.out.println("------------------------------");
           System.out.println("Enter your choice: _\n");

           choice = scanner.nextByte();
           scanner.nextLine();      //Avoiding scanner buffer issues

           switch (choice) {
               case 1:
                   System.out.println("Call the Generate password method and ask for user input");
                   break;
               case 2:
                   System.out.println("Call the manage password manager method and add an existing password");
                   break;
               case 3:
                   System.out.println("View all Saved Passwords");
                   break;
               case 4:
                   System.out.println("Delete a Saved Password");
                   break;
               case 5:
                   System.out.println("Exit");
                   break;
               default:
                   System.out.println("Please Enter one of the following choice");
           }
       } while(choice != 5);        //Only exit when user presses 5

        System.out.println("Generating a Password...\n Please enter the password length: ");
        int length = scanner.nextInt();

        PasswordGenerator generator = new PasswordGenerator(length);
        System.out.println(PasswordGenerator.generate());   //PlaceHolder Method call
        scanner.close();

        System.out.println("\nSaving Data...");
        System.out.println("Goodbye! Stay secure with KeyForge. \uD83D\uDD12");
    }
}