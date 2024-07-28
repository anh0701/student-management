package org.example;

import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender;
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ID: ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.println("Name: ");
        name = sc.nextLine();
        System.out.println("Age: ");
        age = sc.nextInt();
        sc.nextLine();
        System.out.println("Gender: ");
        gender = sc.nextLine();
    }

    public int getId() {
        return id;
    }
}
