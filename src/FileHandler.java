import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {

    private static final String FILE_PATH = "/home/pixel/Documents/saved_passwords.txt";        //Global method since both load and save passwords need this path

    public static Map<String, String> loadPasswords()    //Method to load passwords from file. Return types = map since we are checking for lines in file and returning in a map format
    {
        Map<String, String> map = new HashMap<>();          //To handle the passwords in the file handler and return it
        File file = new File(FILE_PATH);                    //Initializing File path

        if(!file.exists())                //If file doesn't exist yet, we can't load it the Hashmap to be displayed.
            return map;

        try(BufferedReader reader = new BufferedReader(new FileReader(file)))
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
            reader.close();         //Avoiding memory leaks
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found..");
        }
        catch(IOException e)
        {
            System.out.println("Error loading password from file: "+e.getMessage());               //Print the exception cause
        }
        return map;         //The final map carrying all the decoded passwords
    }

    public static void savePasswords(Map<String, String> map){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))){
            for(Map.Entry<String, String> entry : map.entrySet()){          //'Map.Entry' since only one entry is to be taken. Not the whole map everytime
                String label = entry.getKey();
                String rawPassword = entry.getValue();
                String encodedPassword = Encoder.encode(rawPassword);

                writer.write(label+"="+encodedPassword);        //Saving in HashMap format
                writer.newLine();                                   //Jump to next line
            }
            writer.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found..");
        }
        catch (IOException e){
            System.out.println("Error saving password to file: "+e.getMessage());                      //Print the exception cause
        }
        return ;
    }
}
