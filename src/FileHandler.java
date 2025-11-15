import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {

    //Please set this FILE_PATH to where you want to save your passwords
    //Creating global variable since both load and save passwords need this path
    private static final String FILE_NAME = "saved_passwords.txt";      //The actual file name for the saved passwords
    private static final Path FILE_PATH = Paths.get(        //Setting the file path according the home of the user's pc
            System.getProperty("user.home"), ".keyForge", FILE_NAME);

    private static void ensureDirectoryExists(){
        try{
            Files.createDirectories(FILE_PATH.getParent());           //To set the path according to the user's system after the program runs for the 1st time
        }
        catch(Exception e){
            System.out.println("Could not create .keyforge directory: "+e.getMessage());
        }
    }

    public static Map<String, String> loadPasswords()    //Method to load passwords from file. Return types = map since we are checking for lines in file and returning in a map format
    {
        ensureDirectoryExists();
        Map<String, String> map = new HashMap<>();          //To handle the passwords in the file handler and return it

        try(BufferedReader reader = Files.newBufferedReader(FILE_PATH))
        {
            String line;
            while((line = reader.readLine()) != null){      //Read lines till we hit null
                if(line.isBlank()) continue;

                String[] parts = line.split("=", 2);        //Since the password is stored in a hashmap format label=password
                if(parts.length != 2) continue;

                String label = parts[0];
                String encodedPassword = parts[1];

                String decodedPassword = Encoder.decode(encodedPassword);       //Decode the Encoded password before adding it to the map(to be returned)

                map.put(label, decodedPassword);        //The map being displayed to the user in the console
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found..");
        }
        catch(IOException e)
        {
            System.out.println("Error loading password from file: "+e.getMessage());               //Print the exception cause
        }
        return map;         //The final map carrying all the decoded passwords. If directory doesn't exist, return an empty map.
    }

    public static void savePasswords(Map<String, String> map){
        ensureDirectoryExists();
        try(BufferedWriter writer = Files.newBufferedWriter(FILE_PATH)){
            for(Map.Entry<String, String> entry : map.entrySet()){          //'Map.Entry' since only one entry is to be taken. Not the whole map everytime
                String label = entry.getKey();
                String rawPassword = entry.getValue();
                String encodedPassword = Encoder.encode(rawPassword);

                writer.write(label+"="+encodedPassword);        //Saving in HashMap format
                writer.newLine();                                   //Jump to next line
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found..");
        }
        catch (IOException e){
            System.out.println("Error saving password to file: "+e.getMessage());                      //Print the exception cause
        }
    }
}
