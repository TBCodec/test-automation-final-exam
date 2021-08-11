import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Utils {

    private WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public void writeToFile(String line){
        try {
            FileWriter myWriter = new FileWriter("names.txt", true);
            myWriter.append(line + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to file:");
            System.out.println(line);
        }
        catch (IOException e){
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public void sendLineToFile(List<String> lines){
        for (String line : lines){
            writeToFile(line);
        }
    }

    public void clearTxtFile(){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("names.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
    }

}
