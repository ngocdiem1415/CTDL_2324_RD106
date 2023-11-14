package lab9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void addStudent (Student st){
        students.add(st);
    }

    public int isSize(){
        return students.size();
    }

    public List<Student> groupStudent(int year){
        List<Student> list = new ArrayList<>();
        for (Student st: students) {
            if (st.getYear() == year){
                list.add(st);
            }
        }
        return list;
    }

//    public Set<Integer> listYear() {
//        Set<Integer> listYear = new HashSet<>();
//        for (Student i: students  ) {
//            listYear.add(i.getYear());
//        }
//        return listYear;
//    }
}
