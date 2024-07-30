package org.example;

import java.util.HashMap;
import java.util.Map;

public class StudentManagement implements StudentRepository{
    private final Map<Integer, StudentEntity> studentEntities = new HashMap<>();

    public boolean add(StudentEntity studentEntity) {
        if (!studentEntities.containsKey(studentEntity.getId())) {
            studentEntities.put(studentEntity.getId(), studentEntity);
            return true;
        } else {
            return false;
        }
    }

    public Map<Integer, StudentEntity> getstudentEntities() {
        return studentEntities;
    }

    public StudentEntity findById(Integer studentId){
        return studentEntities.get(studentId);
    }

    public boolean deleteById(Integer studentId) {
        if (studentEntities.containsKey(studentId)) {
            studentEntities.remove(studentId);
            return true;
        } else {
            return false;
        }
    }
}
