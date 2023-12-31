package lab8;

import lab7.MyWordCount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyWordCountApp {
//     public static final String fileName = "lab8/data/hamlet.txt";
    public static final String fileName = "lab8/data/fit.txt";
    private Map<String, Integer> map = new HashMap<String, Integer>();

    public MyWordCountApp() throws FileNotFoundException {
        this.loadData();
    }

    // Load data from fileName into the above map (containing <word, its occurences>)
    // using the guide given in TestReadFile.java
    public void loadData() throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        while (input.hasNext()) {
            String word = input.next();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
    }

    // Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
    public int countUnique() {
        // TODO
        return this.map.size();
    }

    // Prints out the number of times each unique token appears in the file
    // data/hamlet.txt (or fit.txt)
    // In this method, we do not consider the order of tokens.
    public void printWordCounts() throws FileNotFoundException {
//        TreeMap<String, Integer> treeMap = new TreeMap<>();
//        treeMap.putAll(this.map);
        System.out.println(this.map);
    }

    // Prints out the number of times each unique token appears in the file
    // data/hamlet.txt (or fit.txt) according to ascending order of tokens
    // Example: An - 3, Bug - 10, ...
    public void printWordCountsAlphabet() {
        TreeMap<String, Integer> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        treeMap.putAll(this.map);
        System.out.println(treeMap);
    }

    public static void main(String[] args) throws FileNotFoundException {
        MyWordCountApp test = new MyWordCountApp();
//        test.printWordCounts();
        test.printWordCountsAlphabet();
//        System.out.println(test);
    }
}
