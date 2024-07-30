package org.example;

import java.util.Map;

public interface StudentRepository {

    boolean add(StudentEntity studentEntity);
    Map<Integer, StudentEntity> getSTUDENT_ENTITIES();
    boolean deleteById(Integer studentId);

    StudentEntity findById(Integer studentId);
}
