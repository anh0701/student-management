package org.example;

import java.util.Map;

public interface StudentRepository {

    boolean add(StudentEntity studentEntity);
    Map<Integer, StudentEntity> getstudentEntities();
    boolean deleteById(Integer studentId);

    StudentEntity findById(Integer studentId);
}
