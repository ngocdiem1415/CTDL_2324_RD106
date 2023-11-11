package lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalyzer {
    public static final String fileName = "lab8/data/hamlet.txt";
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
            StringTokenizer tokens = new StringTokenizer(line, " ");
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
        if (map.containsKey(word)) {
            ArrayList<Integer> value = map.get(word);
            value.add(position);
        } else {
            ArrayList<Integer> value = new ArrayList<>();
            value.add(position);
            map.put(word, value);
        }
    }

    // This method should display the words of the text file along with the
    // positions of each word, one word per line, in alphabetical order
    public void displayWords() {
        TreeMap<String, ArrayList<Integer>> re = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        re.putAll(this.map);
        System.out.println(re);
    }

    // This method will display the content of the text
    // file stored in the map
//    public void displayText() {
//        Set<String> keySet = map.keySet();
//        ArrayList<Integer>  listValues = new ArrayList<>();
//        ArrayList<String> listKey = new ArrayList<>();
//        listKey.addAll(keySet);
////        for ( String key: keySet ) {
////            listValues.addAll(map.get(key));
////        }
//        int index = 1;
//        if ( !listKey.contains(index)){
//            System.out.println();
//        }

    public void displayText() {
        Set<String> setKey = map.keySet();
        List<Integer> listPos = new ArrayList<>();
        List<String> listString = new ArrayList<>();
        for (String key : setKey) {
            listPos.addAll(map.get(key));
            for (Integer temp : map.get(key)) {
                listString.add(key);
            }
        }
        int index = 0;
        while ( index < listString.size()){
            index++;
            if (!listPos.contains(index)) {
                System.out.print(listString.get(listPos.indexOf(-index)) + " ");
                System.out.println();
            } else System.out.print(listString.get(listPos.indexOf(index)) + " ");
        }
    }

//    public int countAllWords() {
//        int count = 0;
//        for (String word : map.keySet()) {
//            count += map.get(word).size();
//        }
//        System.out.println(count);
//        return count;
//    }
//    public void displayText1() {
//        int count = countAllWords();
//        String content[] = new String[count];
//        for (String word : map.keySet()) {
//            for (int i = 0; i < map.get(word).size(); i++) {
//                content[map.get(word).get(i)] = word;
//            }
//        }
//        for (int i = 0; i < content.length; i++) {
//            System.out.print(" " + content[i]);
//        }
//
//    }

    // This method will return the word that occurs most frequently in the text file
    public String mostFrequentWord() {
        // TODO
        return null;
    }

    @Override
    public String toString() {
        return "TextAnalyzer{" +
                "map=" + map +
                '}';
    }

    public static void main(String[] args) throws IOException {
        TextAnalyzer test = new TextAnalyzer();
//        test.displayWords();
        test.displayText();
//        System.out.println(test.toString());
    }
}
