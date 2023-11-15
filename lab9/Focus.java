package lab9;

public class Focus extends Publication {
    private String name;

    public Focus(String title, int page, int publishYear, String author, double cost, String name) {
        super(title, page, publishYear, author, cost);
        this.name = name;
    }

    @Override
    public String isType(){
        return "Focus";
    }

    @Override
    public boolean isFocusAnd10PublishYear() {
        return this.getPublishYear() == 2021 ;
    }

    @Override
    public int isSizeChaper() {
        return 0;
    }


    @Override
    public String toString() {
        return super.toString() + name +"\n" ;
    }
}
