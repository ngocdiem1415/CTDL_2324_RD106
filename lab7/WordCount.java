package lab7;

public class WordCount {
    private String words;
    private int count;

    public WordCount(String words, int count) {
        this.words = words;
        this.count = count;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + words.hashCode();
        result = prime * result + count;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
//        System.out.println("called.");
        if (obj == null || obj.getClass() != getClass())
            return false;
        else {
            WordCount c = (WordCount) obj;
            return this.words.equals(c.words);
        }
    }

    @Override
    public String toString() {
        return words + ";" + count;
    }
}
