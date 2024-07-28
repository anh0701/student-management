package org.example;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    private List<Student> students = new ArrayList<>();
    public void add(Student student){
        students.add(student);
    }

    public void getList(){
        for (Student s : students){
            System.out.println(s.toString());
        }
    }
    public void delete(int id){
        Student s = null;
        for (Student student : students){
            if (student.getId() == id){
                s = student;
            }
        }
        if (s == null){
            System.out.println("Not found");
        }else{
            students.remove(s);
            System.out.println("remove success");
        }
    }
}
