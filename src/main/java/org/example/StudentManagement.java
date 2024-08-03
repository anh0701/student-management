package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentManagement implements StudentRepository{
    private DatabaseConfig databaseConfig = new DatabaseConfig();
    private static final String SELECT = "select * from student";
    private static final String SELECT_BY_ID = "select * from student where id = ?";
    private  static  final String UPDATE = "update student set name = ?, age = ?, gender = ? ::bit where id = ?";
    private  static final String DELETE = "delete from student where id = ?";
    private static final String INSERT = "insert into student (name, age, gender) values (?,?,? ::bit)";

    public StudentManagement() {
        databaseConfig.connected();
    }

    @Override
    public boolean add(Student student) {
        try{
            int gender = student.getGender().equals("nu") ? 1: 0;
            PreparedStatement stmt = databaseConfig.getConnection().prepareStatement(INSERT);
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setInt(3, gender);
            stmt.execute();
//            databaseConfig.queryWithParameter(INSERT, student.getName(), student.getAge(), gender);
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Student> getStudents() throws SQLException {
        Statement st = databaseConfig.getConnection().createStatement();
        ResultSet rs = st.executeQuery(SELECT);
        List<Student> students = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String gender = rs.getInt(4) == 1 ? "nu" : "nam";
            int age = rs.getInt(3);

            Student student = new Student(id, name, age, gender);
            students.add(student);
        }
        return students;
    }

    @Override
    public Student findById(Integer studentId) throws SQLException {
        PreparedStatement stmt= databaseConfig.getConnection().prepareStatement(SELECT_BY_ID);
        stmt.setInt(1, studentId);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String gender = rs.getInt(4) == 1 ? "nu" : "nam";
            int age = rs.getInt(3);

            Student student = new Student(id, name, age, gender);
            return student;
        }
        return null;
    }

    @Override
    public boolean deleteById(Integer studentId) throws SQLException {
        if (findById(studentId) != null) {
            PreparedStatement stmt = databaseConfig.getConnection().prepareStatement(DELETE);
            stmt.setInt(1, studentId);
            stmt.execute();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateById(Student student) throws SQLException {
        if (findById(student.getId()) != null){
            int gender = student.getGender().equals("nu") ? 1 : 0;
//            databaseConfig.queryWithParameter(UPDATE, student.getName(), student.getAge(), student.getGender(), student.getId());
            PreparedStatement stmt = databaseConfig.getConnection().prepareStatement(UPDATE);
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setInt(3, gender);
            stmt.setInt(4, student.getId());
            stmt.execute();
            return true;
        }
        return false;
    }
}
