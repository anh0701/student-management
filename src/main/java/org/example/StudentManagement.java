package org.example;

import java.util.ArrayList;
import java.util.List;

public class StudentManagement implements StudentRepository{
    private static final List<StudentEntity> STUDENT_ENTITIES = new ArrayList<>();

    public boolean add(StudentEntity studentEntity) {
        if (findById(studentEntity.getId()) == null) {
            STUDENT_ENTITIES.add(studentEntity);
            return true;
        } else {
            return false;
        }
    }

    public List<StudentEntity> getStudents() {
        return STUDENT_ENTITIES;
    }

    public StudentEntity findById(int id) {
        for (StudentEntity studentEntity : STUDENT_ENTITIES) {
            if (studentEntity.getId() == id) {
                return studentEntity;
            }
        }
        return null;
    }

    public boolean deleteById(int id) {
        return STUDENT_ENTITIES.remove(findById(id));
    }
}
