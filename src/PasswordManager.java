import java.util.HashMap;
import java.util.Map;
public class PasswordManager {

    private Map<String, String> passwordMap = new HashMap<>();      //Storing label : value pairs - Scoped only for all the methods in this file

    public void save(String label, String password){

        passwordMap.put(label, password);                       //Saving the label : password pairs
        System.out.println("Password Stored");
    }

    public void view(){
        for(Map.Entry<String, String> entry : passwordMap.entrySet())
        {
            System.out.println(entry);
        }
    }

    public void delete(String label){
        passwordMap.remove(label);
        System.out.println("Password Deleted");
    }
}
