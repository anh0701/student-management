package org.example;

import java.util.Scanner;

public class StudentSystem {

    private StudentManagement studentManagement = new StudentManagement();
    public void menu(){

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {

            System.out.println("Menu");
            System.out.println("1. add a student");
            System.out.println("2. delete a student");
            System.out.println("3. display a student");
            System.out.println("4. display list students");
            System.out.println("5. Exit");
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
                    int delStudentId = sc.nextInt();
                    deleteById(delStudentId);
                    break;
                case 3:
                    System.out.println("ID: ");
                    int findStudentId = sc.nextInt();
                    displayStudentById(findStudentId);
                    break;
                case 4:
                    displayStudentList();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Error");
                    break;
            }

        }while (choice != 5);

    }

    private Student createStudentFromStdio() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Gender: ");
        String gender = sc.nextLine();

        Student student = new Student(id, name, age, gender);

        return student;
    }

    public void displayStudentList() {
        for (Student student : studentManagement.getStudents()){
            System.out.println(student.toString());
        }
    }

    public void displayStudentById(int id) {
        if (studentManagement.findById(id) == null){
            System.out.println("Not found");
        } else {
            System.out.println(studentManagement.findById(id).toString());
        }
    }

    public void deleteById(int id) {
        if (studentManagement.findById(id) == null){
            System.out.println("Not found");
        } else{
            studentManagement.deleteById(id);
            System.out.println("remove success");
        }
    }

    public void add(Student student) {
        if (!studentManagement.add(student)){
            System.out.println("duplicate ID");
        } else{
            System.out.println("Success");
        }
    }
}
