import java.util.Base64;

public class Encoder {

    public static String encode(String rawPassword){
        return Base64.getEncoder().encodeToString(rawPassword.getBytes());      //Returns the String after encoding it to write in the file
    }

    public static String decode(String encodedPassword){
        byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);      //Returns the String formed from the decoded bytes
        return new String(decodedBytes);
    }
}
