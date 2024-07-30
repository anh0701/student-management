package org.example;

/**
 * using encapsulation (private, public)
 * using polymorphism (override toString(), add(), getSTUDENT_ENTITIES(), deleteById(), findById() method)
 * using abstraction (interface StudentRepository)
 */

public class Main {
    public static void main(String[] args) {
        StudentSystem studentSystem = new StudentSystem();
        studentSystem.menu();
    }

}