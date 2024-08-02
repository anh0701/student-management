package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentSystem {

    private final StudentRepository studentRepository= new StudentManagement();
    public void menu() throws SQLException {
        String url = DatabaseConfig.getDbUrl();
        String username = DatabaseConfig.getDbUsername();
        String password = DatabaseConfig.getDbPassword();

        Connection connection = DriverManager.getConnection(url, username, password);
        if (connection != null){
            System.out.println("Connect db success");
        }

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {

            System.out.println("Menu");
            System.out.println("1. add a student");
            System.out.println("2. delete a student");
            System.out.println("3. update a student");
            System.out.println("4. display a student");
            System.out.println("5. display list students");
            System.out.println("6. Exit");
            System.out.println("selection: ");

            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    try{
                        Student student = createStudentFromStdio();
//                        System.out.println(student.toString());
                        add(student);
                    }catch (Exception e){
                        e.printStackTrace(System.out);
                    }
                    break;
                case 2:
                    System.out.println("ID: ");
                    Integer delStudentId = sc.nextInt();
                    deleteById(delStudentId);
                    break;
                case 3:
                    Student student = createStudentFromStdio();
                    update(student);
                    break;
                case 4:
                    System.out.println("ID: ");
                    Integer findStudentId = sc.nextInt();
                    displayStudentById(findStudentId);
                    break;
                case 5:
                    displayStudentList();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Error");
                    break;
            }

        }while (choice != 6);

    }

    private Student createStudentFromStdio() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ID: ");
        Integer id = sc.nextInt();
        sc.nextLine();
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Age: ");
        Integer age = sc.nextInt();
        sc.nextLine();
        System.out.println("Gender: ");
        String gender = sc.nextLine();

        Student student = new Student(id, name, age, gender);
        
        return student;
    }

    public void displayStudentList() {
        for (Student student : studentRepository.getStudents().values()){
            System.out.println(student.toString());
        }
    }

    public void displayStudentById(Integer id) {
        if (studentRepository.findById(id) != null){
            System.out.println(studentRepository.findById(id));
        }else {
            System.out.println("Not found");
        }
    }

    public void deleteById(Integer id) {
       if (studentRepository.deleteById(id)){
           System.out.println("remove success");
       }else {
           System.out.println("Fail");
       }
    }

    public void add(Student student) {
        if (!studentRepository.add(student)){
            System.out.println("duplicate ID");
        } else{
            System.out.println("Success");
        }
    }

    public void update(Student student){
        if ((studentRepository.updateById(student))){
            System.out.println("Success");
        }else{
            System.out.println("Error");
        }
    }
}
