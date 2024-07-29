package org.example;

import java.util.Scanner;

/**
 * using encapsulation (private, public)
 * using polymorphism (override toString() method)
 * using abstraction (List<Student> students = new ArrayList<>())
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagement students = new StudentManagement();
        StudentSystem studentSystem = new StudentSystem();
        int choice = 0;
        do {
            studentSystem.menu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    try{
                        Student student = studentSystem.insert();
                        students.add(student);
                    }catch (Exception ignored){
                        System.out.println("Error input");
                    }
                    break;
                case 2:
                    System.out.println("ID: ");
                    int delStudentId = sc.nextInt();
                    students.deleteById(delStudentId);
                    break;
                case 3:
                    System.out.println("ID: ");
                    int findStudentId = sc.nextInt();
                    students.getStudent(findStudentId);
                    break;
                case 4:
                    students.getAll();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Error");
                    break;
            }

        }while (choice != 6);
    }

}