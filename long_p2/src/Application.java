import java.io.File;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        DuplicateCounter duplicateCounter = new DuplicateCounter();

        try {
            File file = new File("problem2.txt");
            File output = new File("unique_word_counts.txt");

            duplicateCounter.count(file);
            duplicateCounter.write(output);
        } catch (IOException e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
