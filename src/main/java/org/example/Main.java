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
        Student s = new Student();
        StudentList students = new StudentList();
        int choice = 0;
        do {
            menu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    s.input();
                    System.out.println(s.toString());
                    break;
                case 2:
                    System.out.println("number of students: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        Student student = new Student();
                        student.input();
                        students.add(student);
                    }
                    students.getList();
                    break;
                case 3:
                    System.out.println("ID: ");
                    int id = sc.nextInt();
                    students.delete(id);
                    break;
                case 4:
                    System.out.println(s.toString());
                    break;
                case 5:
                    students.getList();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Error");
                    break;
            }

        }while (choice != 6);
    }

    public static void menu(){
        System.out.println("Menu");
        System.out.println("1. add student");
        System.out.println("2. add list students");
        System.out.println("3. delete student");
        System.out.println("4. display student");
        System.out.println("5. display list students");
        System.out.println("6. Exit");
        System.out.println("selection: ");
    }
}