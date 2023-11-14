package lab9;

import java.util.*;

public class Faculty {
    private String name;
    private String address;
    private List<Course> courses;

    public Faculty(String name, String address, List<Course> courses) {
        this.name = name;
        this.address = address;
        this.courses = courses;
    }

    public Course getMaxPracticalCourse() {
        Course temp = courses.get(0);
        if (courses.size() < 0) {
            return null;
        } else {
            for (int i = 1; i < courses.size(); i++) {
                if (temp.isSize() < courses.get(i).isSize()) {
                    temp = courses.get(i);
                }
            }
        }
        return temp;
    }

    public Map<Integer, List<Student>> groupStudentByYear(){
        int year = 2000;
        Map<Integer, List<Student>> map = new HashMap<>();

        return map;
    }

    public Set<Course> filterCourses(String type){
        Set<Course> result = new HashSet<>();
        return result;
    }

    @Override
    public String toString() {
        return  name +" " + address +" " + courses +"\n";
    }

    public static void main(String[] args) {
        Student st1 = new Student("1", "Nguyen VAn A", 2012);
        Student st2= new Student("5", "Nguyen VAn B", 2012);
        Student st3 = new Student("8", "Nguyen VAn C", 2019);
        List<Student> l1 = new ArrayList<>();
        l1.add(st1);
        l1.add(st2);
        l1.add(st3);
        Course c1 = new Course("1", "TH1", "TH", l1, "A");

        Student st4 = new Student("3", "Nguyen VAn D", 2022);
        Student st5 = new Student("4", "Nguyen VAn E", 2011);
        Student st6 = new Student("2", "Nguyen VAn F", 2018);
        List<Student> l2 = new ArrayList<>();
        l2.add(st4);
        l2.add(st5);
        l2.add(st6);
        Course c2 = new Course("2", "LT1", "LT", l2, "B");

        Student st7 = new Student("11", "Nguyen VAn H", 2014);
        Student st8 = new Student("12", "Nguyen VAn J", 2017);
        Student st9 = new Student("13", "Nguyen VAn L", 2023);
        List<Student> l3 = new ArrayList<>();
        l3.add(st7);
        l3.add(st8);
        l3.add(st9);
        Course c3 = new Course("3", "LT3", "LT", l3, "C");

        List<Course> course = new ArrayList<>();
        course.add(c1);
        course.add(c2);
        course.add(c3);
        Faculty test = new Faculty("A", "123/2A", course);

        System.out.println(test);

    }
}
