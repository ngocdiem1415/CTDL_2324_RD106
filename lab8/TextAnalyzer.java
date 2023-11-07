package lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalyzer {
    public static final String fileName = "lab8/data/fit.txt";
    // <word, its positions>
    private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

    public TextAnalyzer() throws IOException {
        this.load(fileName);
    }

    // load words in the text file given by fileName and store into map by using add
    // method in Task 2.1.
    // Using BufferedReader reffered in file TextFileUtils.java
    public void load(String fileName) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(fileName));
        String line = null;
        int index = 1;
        while (true) {
            line = r.readLine();//null
            if (line == null) break;
            StringTokenizer tokens = new StringTokenizer(line, "");
            while (tokens.hasMoreTokens()) {
                String word = tokens.nextToken();
                if (!tokens.hasMoreTokens()) {
                    add(word, -index);
                } else {
                    add(word, index);
                }
                index++;
            }
        }
    }
    // In the following method, if the word is not in the map, then adding that word
    // to the map containing the position of the word in the file. If the word is
    // already in the map, then its word position is added to the list of word
    // positions for this word.
    // Remember to negate the word position if the word is at the end of a line in
    // the text file

    public void add(String word, int position) {
        if ( !map.containsKey(word)){
            ArrayList<Integer> value = new ArrayList<>();
            value.add(position);
            map.put(word, );
        }else{

        }
        // TODO
    }

    // This method should display the words of the text file along with the
    // positions of each word, one word per line, in alphabetical order
    public void displayWords() {
        // TODO
    }

    // This method will display the content of the text file stored in the map
    public void displayText() {
        // TODO
    }

    // This method will return the word that occurs most frequently in the text file
    public String mostFrequentWord() {
        // TODO
        return null;
    }

    public String toString() {
        return "" +map +"";
    }

    public static void main(String[] args) throws  IOException{
        TextAnalyzer test = new TextAnalyzer();
        System.out.println(test);
    }
}
