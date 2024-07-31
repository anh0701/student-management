package org.example;

import java.util.Map;

public interface StudentRepository {

    boolean add(Student student);
    Map<Integer, Student> getStudents();
    boolean deleteById(Integer studentId);
    Student findById(Integer studentId);
    boolean updateById(Student student);
}
