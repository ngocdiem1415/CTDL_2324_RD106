package lab9.task1;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private int year;

    public Student(String id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return id +" "+ name +" "+  year +"  ";
    }
}
