package src;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException; 

public class WriteReult{

    WriteReult(String filename){
        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
}
