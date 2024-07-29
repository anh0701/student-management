package org.example;


public class StudentEntity {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;

    public StudentEntity(Integer id, String name, Integer age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender;
    }

    public Integer getId() {
        return id;
    }
}
