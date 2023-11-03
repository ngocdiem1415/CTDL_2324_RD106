package lab7;

import java.io.FileNotFoundException;
import java.util.*;

public class MyWordCount implements Comparator<WordCount> {
    public static final String fileName = "lab7/data/fit.txt";
    private List<String> words = new ArrayList<>();


    public MyWordCount() {
        try {
            this.words.addAll(Utils.loadWords(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //tra ve so lan 1 tu xuat hien
    public int countWords(String w) {
        int count = 0;
        for (String i : words) {
            if (i.equals(w)) {
                count++;
            }
        }
        return count;
    }

    //tra ve ds  cac wordCount xuat hien khong trung nhau
    public List<WordCount> getWordCount() {
        List<WordCount> result = new ArrayList<>();
        for (String w : words) {
            WordCount wc = new WordCount(w, countWords(w));
            if (!result.contains(wc)) {
                result.add(wc);
            }
        }
        return result;
    }

    // tra ve list cac tu co so lan xuat hien la 1 ( list kh trung nhau)
    public Set<String> getUniqueWords() {
        Set<String> re = new HashSet<>();
        List<WordCount> list = getWordCount();
        for (WordCount w : list) {
            if (w.getCount() == 1) {
                re.add(w.getWords());
            }
        }
        return re;
    }

    // tra ve list cac tu co so lan xuat hien lon hon 1 ( list kh trung nhau)
    public Set<String> getDistinctWords() {
        Set<String> result = new HashSet<>();
        List<WordCount> list = getWordCount();
        for (WordCount w : list) {
            if (w.getCount() > 1) {
                result.add(w.getWords());
            }
        }
        return null;
    }

    //in ra list cac tu duoc sap xếp theo thứ tự tăng dần
    public Set<WordCount> exportWordCounts() {
        Set<WordCount> result = new TreeSet<>(new Comparator<WordCount>() {
            @Override
            public int compare(WordCount o1, WordCount o2) {
                return o1.getWords().compareTo(o2.getWords());
            }
        });
        result.addAll(getWordCount());
        return result;
    }

    //in ra list cac tu duoc sap xếp theo thứ tự giam dan cua count
    public Set<WordCount> exportCountsOrderByOccurence() {
        Set<WordCount> result = new TreeSet<>(new Comparator<WordCount>() {
            @Override
            public int compare(WordCount o1, WordCount o2) {
                return -(o1.getCount() - o2.getCount());
                //sua them truong hop 2 cai bang nhau
            }
        });
        result.addAll(getWordCount());
        return result;
    }

    //in ra list cac tu duoc sap xếp theo thứ tự tăng dần
    public Set<WordCount> filterWords(String pattern) {
        Set<WordCount> result = new TreeSet<>(this);
        if (pattern == null) {
            result.addAll(getWordCount());
            return result;
        } else {
            for (WordCount i : getWordCount()) {
                String temp = i.getWords();
                if (!(temp.equals(pattern))) {
                    result.add(i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MyWordCount test = new MyWordCount();
        System.out.println(test.filterWords("Dai"));
//        System.out.println(test.getWordCount());
    }

    @Override
    public int compare(WordCount o1, WordCount o2) {
        return o1.getWords().toUpperCase().compareTo(o2.getWords().toUpperCase());
    }
}
