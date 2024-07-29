package org.example;

import java.util.List;

public interface StudentRepository {
    boolean add(StudentEntity studentEntity);
    List<StudentEntity> getStudents();
    boolean deleteById(int id);
}
