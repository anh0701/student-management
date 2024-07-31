package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class StudentManagement implements StudentRepository{
    private final Map<Integer, Student> students = new HashMap<>();

    @Override
    public boolean add(@NotNull Student student) {
        if (!students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Map<Integer, Student> getStudents() {
        return students;
    }

    @Override
    public Student findById(Integer studentId){
        return students.get(studentId);
    }

    @Override
    public boolean deleteById(Integer studentId) {
        if (students.containsKey(studentId)) {
            students.remove(studentId);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateById(Student student) {
        if (findById(student.getId()) != null){
            students.put(student.getId(), student);
            return true;
        }
        return false;
    }
}
