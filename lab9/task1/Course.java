package lab9.task1;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String id;
    private String title;
    private String type;
    private List<Student> students;
    private String lecturer;

    public Course(String id, String title, String type, List<Student> student, String lecturer) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.students = student;
        this.lecturer = lecturer;
    }

    @Override
    public String toString() {
        return "\n" +id + " " +title +" "+  type +" "+ students +" "+ lecturer;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getType() {
        return type;
    }

    public void addStudent (Student st){
        students.add(st);
    }

    public int isSize(){
        return students.size();
    }


}
