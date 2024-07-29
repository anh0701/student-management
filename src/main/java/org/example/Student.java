package org.example;


public class Student {
    private final int id;
    private final String name;
    private final int age;
    private final String gender;

    public Student(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender;
    }

    public int getId() {
        return id;
    }
}
