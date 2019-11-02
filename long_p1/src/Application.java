import java.io.File;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        DuplicateRemover duplicateRemover = new DuplicateRemover();

        try
        {
            File file = new File("problem1.txt");
            File output = new File("unique_words.txt");

            duplicateRemover.remove(file);
            duplicateRemover.write(output);
        }
        catch(IOException e)
        {
            System.out.println("Error: " + e.toString());
        }
    }
}
