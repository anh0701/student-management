package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagement implements StudentRepository{
    private static StudentManagement instance;
    private DataSource dataSource ;
    private static final Logger logger = LoggerFactory.getLogger(StudentManagement.class);
    private static final String SELECT = "select * from student";
    private static final String SELECT_BY_ID = "select * from student where id = ?";
    private  static  final String UPDATE = "update student set name = ?, age = ?, gender = ? where id = ?";
    private  static final String DELETE = "delete from student where id = ?";
    private static final String INSERT = "insert into student (name, age, gender) values (?,?,?)";

    private StudentManagement() {
        dataSource = new DataSource();
    }

    public static StudentManagement getInstance() {
        if (instance == null) {
            synchronized (StudentManagement.class) {
                if (instance == null) {
                    instance = new StudentManagement();
                }
            }
        }
        return instance;
    }

    @Override
    public boolean add(Student student) {
        try{
            Connection conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            boolean gender = student.getGender().equals("nu");
            try (PreparedStatement stmt = conn.prepareStatement(INSERT)) {
                stmt.setString(1, student.getName());
                stmt.setInt(2, student.getAge());
                stmt.setBoolean(3, gender);
                stmt.executeUpdate();
                conn.commit();
                logger.info("insert success");
                return true;
            } catch (SQLException e) {
                conn.rollback();
                logger.info(e.toString());
                e.printStackTrace();
            }

        } catch (SQLException e){
            logger.info(e.toString());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Student> getStudents() throws SQLException {
        Statement st = dataSource.getConnection().createStatement();
        ResultSet rs = st.executeQuery(SELECT);
        List<Student> students = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String gender = rs.getBoolean(4) ? "nu" : "nam";
            int age = rs.getInt(3);

            Student student = new Student(id, name, age, gender);
            students.add(student);
        }
        return students;
    }

    @Override
    public Student findById(Integer studentId) throws SQLException {
        PreparedStatement stmt= dataSource.getConnection().prepareStatement(SELECT_BY_ID);
        stmt.setInt(1, studentId);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String gender = rs.getBoolean(4) ? "nu" : "nam";
            int age = rs.getInt(3);

            Student student = new Student(id, name, age, gender);
            return student;
        }
        return null;
    }

    @Override
    public boolean deleteById(Integer studentId) throws SQLException {
        if (findById(studentId) != null) {
            Connection conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(DELETE)) {
                stmt.setInt(1, studentId);
                stmt.executeUpdate();
                conn.commit();
                logger.info("delete success student id = " + studentId);
                return true;
            } catch (SQLException e) {
                conn.rollback();
                logger.info(e.toString());
                e.printStackTrace();
            }
        } else {
            logger.info("Not found student id = " + studentId);
        }
        return false;
    }

    @Override
    public boolean updateById(Student student) throws SQLException {
        if (findById(student.getId()) != null){
            boolean gender = student.getGender().equals("nu");
            Connection conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
                stmt.setString(1, student.getName());
                stmt.setInt(2, student.getAge());
                stmt.setBoolean(3, gender);
                stmt.setInt(4, student.getId());
                stmt.executeUpdate();
                conn.commit();
                logger.info("update succes student id = " + student);
                return true;
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
                logger.info(e.toString());
            }

        }
        logger.info("Not found student id = %d", student.getId());
        return false;
    }
}
