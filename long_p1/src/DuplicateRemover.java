import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
    public int index = 0;
    Set<String> uniqueWords = new HashSet<>();

    public void remove(File dataFile) throws FileNotFoundException
    {
        Scanner scnr = new Scanner(dataFile);
        Iterator iterator = uniqueWords.iterator();
        String currWord = scnr.next();
        int found = -9999;
        uniqueWords.add(currWord);

        while(scnr.hasNext())
        {
            while(iterator.hasNext())
            {
                if(iterator.next().equals(currWord))
                    found = 1;
            }

            if(found != 1)
            {
                index++;
                uniqueWords.add(currWord);
            }
            found = -9999;
            currWord = scnr.next();
        }

        scnr.close();
    }

    public void write(File outputFile) throws IOException {
        FileWriter fw = new FileWriter("unique_words.txt");
        Iterator iterator = uniqueWords.iterator();
        int i = 0;

        while(iterator.hasNext())
        {
            fw.write((String) iterator.next());
            fw.write("\n");
        }

        fw.close();
    }
}
