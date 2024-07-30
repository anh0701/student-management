package org.example;

import java.util.HashMap;
import java.util.Map;

public class StudentManagement implements StudentRepository{
    private static final Map<Integer, StudentEntity> STUDENT_ENTITIES = new HashMap<>();

    public boolean add(StudentEntity studentEntity) {
        if (!STUDENT_ENTITIES.containsKey(studentEntity.getId())) {
            STUDENT_ENTITIES.put(studentEntity.getId(), studentEntity);
            return true;
        } else {
            return false;
        }
    }

    public Map<Integer, StudentEntity> getSTUDENT_ENTITIES() {
        return STUDENT_ENTITIES;
    }

    public StudentEntity findById(Integer studentId){
        return STUDENT_ENTITIES.get(studentId);
    }

    public boolean deleteById(Integer studentId) {
        if (STUDENT_ENTITIES.containsKey(studentId)) {
            STUDENT_ENTITIES.remove(studentId);
            return true;
        } else {
            return false;
        }
    }
}
