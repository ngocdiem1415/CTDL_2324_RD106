package lab9.task1;

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
        Course temp = null;
        if (courses.size() < 0) {
            return null;
        } else {
            for ( int i =0; i < courses.size(); i+=2) {
                if ( courses.get(i).getType().equals("TH")){
                    if (courses.get(i).isSize() < courses.get(i+1).isSize()) {
                        temp = courses.get(i +1);
                    }else{
                        temp = courses.get(i);
                    }
                }
            }
        }
        return temp;
    }

    public Map<Integer, List<Student>> groupStudentByYear(){
        Map<Integer, List<Student>> map = new HashMap<>();
        for ( Course temp: courses ) {
            List<Student> liststudent = temp.getStudents();
            for (Student st : liststudent) {
                int key = st.getYear();
                if (!map.containsKey(key)){
                    List<Student> list = new ArrayList<>();
                    list.add(st);
                    map.put(key, list);
                }else{
                    map.get(key).add(st);
                }
            }
        }
        return map;
    }

    public Set<Course> filterCourses(String type){
        Set<Course> result = new TreeSet<>(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o2.isSize() - o1.isSize();
            }
        });
        for (Course temp :courses) {
            if (temp.getType().equalsIgnoreCase(type)){
                result.add(temp);
            }
        }
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
        Student st10 = new Student("20", "Nguyen VAn W", 2023);
        List<Student> l3 = new ArrayList<>();
        l3.add(st7);
        l3.add(st8);
        l3.add(st9);
        l3.add(st10);
        Course c3 = new Course("3", "LT3", "LT", l3, "C");

        List<Course> course = new ArrayList<>();
        course.add(c1);
        course.add(c2);
        course.add(c3);
        Faculty test = new Faculty("A", "123/2A", course);

//        System.out.println(test.groupStudentByYear());
//        System.out.println(test.getMaxPracticalCourse());
        System.out.println(test.filterCourses("lt"));

    }
}
