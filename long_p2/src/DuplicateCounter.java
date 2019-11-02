import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {

    Map<String, Integer> wordCounter = new HashMap<String, Integer>();

    public void count(File datafile) throws FileNotFoundException {
        Scanner scnr = new Scanner(datafile);
        String currWord;
        int found = -9999;

        while(scnr.hasNext())
        {
            currWord = scnr.next();
            Iterator<Map.Entry<String, Integer>> itr = wordCounter.entrySet().iterator();

            while(itr.hasNext())
            {
                if(itr.next().getKey().equals(currWord))
                {
                    int currWordVal = (wordCounter.get(currWord)) + 1;
                    wordCounter.replace(currWord, currWordVal);
                    found = 1;
                }
            }

            if(found != 1)
            {
                wordCounter.put(currWord, 1);
            }

            found = -9999;
        }

        scnr.close();
    }

    public void write(File outputFile) throws IOException {
        FileWriter fw = new FileWriter("unique_word_counts.txt");

        for (Map.Entry<String, Integer> entry : wordCounter.entrySet())
            fw.write( entry.getKey() + ", " + entry.getValue() + "\n");

        fw.close();
    }
}
