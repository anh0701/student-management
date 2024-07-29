package org.example;

import java.util.Scanner;

/**
 * using encapsulation (private, public)
 * using polymorphism (override toString() method)
 * using abstraction (List<Student> students = new ArrayList<>())
 */

public class Main {
    public static void main(String[] args) {
        StudentSystem studentSystem = new StudentSystem();
        studentSystem.menu();
    }

}