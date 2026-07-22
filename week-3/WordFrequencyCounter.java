import java.io.*;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();

        try {
            // Read from input file
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line;
            while ((line = br.readLine())!= null) {
                String[] words = line.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
            br.close();

            // Write to output file
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            bw.write("Word Frequency Count\n--------------------\n");
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                bw.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            bw.close();

            System.out.println("Word count done! Check output.txt");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
