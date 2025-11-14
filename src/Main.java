import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PasswordGenerator generator = new PasswordGenerator();
        PasswordManager manager = new PasswordManager();

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
                   String password = generator.generate();        //Method to generate a password
                   System.out.println("Do you want to save this password? (y/n): ");    //User wants to save it?
                   boolean savePass = scanner.nextLine().equalsIgnoreCase("y");

                   if(savePass){        //Add it to the manager if 'y'
                       System.out.println("Enter a label for this password(e.g., gmail): ");
                       String label = scanner.nextLine().toLowerCase();     //Label for the password
                       manager.save(label, password);                       //Save the pair to the manager map
                   }
                   break;
               case 2:
                   System.out.println("Enter Label(e.g., instagram)");
                   String customLabel = scanner.nextLine().toLowerCase();
                   System.out.println("Enter your password: ");
                   String customPassword = scanner.nextLine();          //Includes whatever characters, numbers and symbols that the user wants
                   manager.save(customLabel, customPassword);
                   break;
               case 3:
                   System.out.println("\nViewing Saved passwords....\n");
                   manager.view();
                   System.out.println();
                   break;
               case 4:
                   System.out.println("Enter the password label to be deleted: ");
                   String label = scanner.nextLine().toLowerCase();
                   manager.delete(label);
                   break;
               case 5:
                   System.out.println("\nSaving Data...");
                   System.out.println("Goodbye! Stay secure with KeyForge. \uD83D\uDD12");
                   break;
               default:
                   System.out.println("Please Enter one of the following choice");
           }
       } while(choice != 5);        //Only exit when user presses 5

        scanner.close();
    }
}