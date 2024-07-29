package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private List<Student> students = new ArrayList<>();


    public void add(Student student){
        if(findById(student.getId()) == null){
            students.add(student);
        } else {
            System.out.println("duplicate ID");
        }

    }

    public void getAll() {
        for (Student s : students){
            System.out.println(s.toString());
        }
    }

    public void getStudent(int id) {
        if (findById(id) == null) {
            System.out.println("Not found");
        } else {
            System.out.println(findById(id).toString());
        }
    }

    public Student findById(int id) {
        for (Student student : students){
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        if (findById(id) == null) {
            System.out.println("Not found");
        }else{
            students.remove(findById(id));
            System.out.println("remove success");
        }
    }
}
