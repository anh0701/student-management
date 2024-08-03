package org.example;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface StudentRepository {

    boolean add(Student student);
    List<Student> getStudents() throws SQLException;
    boolean deleteById(Integer studentId) throws SQLException;
    Student findById(Integer studentId) throws SQLException;
    boolean updateById(Student student) throws SQLException;
}
