import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PasswordManager {

    private Scanner scanner = new Scanner(System.in);
    private Map<String, String> passwordMap = new HashMap<>();      //Storing label : value pairs - Scoped only for all the methods in this file

    public void save(String label, String password){

        passwordMap.put(label, password);                       //Saving the label : password pairs
        System.out.println("Password Stored");
    }

    public void view(){
        if(passwordMap.isEmpty()){
            System.out.println("\n \uD83D\uDD0D No passwords stored.\n");       //If user view the empty list
            return ;
        }
        System.out.println("\n===== \uD83D\uDD10 Saved Passwords ===== \n");
        for(Map.Entry<String, String> entry : passwordMap.entrySet())
        {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());        //Prints the label : password pair in a clean format
        }
        System.out.println("\n==============================\n");
    }

    public void delete(String label){
        if(passwordMap.containsKey(label)){
            System.out.println("Are you sure? (y/n): ");
            boolean sure = scanner.nextLine().equalsIgnoreCase("y");

            if(sure){
                passwordMap.remove(label);
                System.out.println("✔ Removed Entry " + label);
                System.out.println();
            }
        }
        else{
            System.out.println("❌ No Entry found for label: " + label);
            System.out.println();
        }
    }
}
