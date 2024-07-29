package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private List<Student> students = new ArrayList<>();

    public boolean add(Student student){
        if(findById(student.getId()) == null){
            students.add(student);
            return true;
        } else {
            return false;
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student findById(int id) {
        for (Student student : students){
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public boolean deleteById(int id){
        return students.remove(findById(id));
    }
}
