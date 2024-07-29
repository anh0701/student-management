package org.example;

import java.util.Scanner;

public class StudentSystem {
    public void menu(){
        System.out.println("Menu");
        System.out.println("1. add a student");
        System.out.println("2. delete a student");
        System.out.println("3. display a student");
        System.out.println("4. display list students");
        System.out.println("5. Exit");
        System.out.println("selection: ");
    }

    public Student insert() {
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
}
