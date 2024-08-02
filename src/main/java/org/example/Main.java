package org.example;

import java.sql.SQLException;

/**
 * using encapsulation (private, public)
 * using polymorphism (override toString(), add(), getSTUDENT_ENTITIES(), deleteById(), findById() method)
 * using abstraction (interface StudentRepository)
 */

public class Main {
    public static void main(String[] args) throws SQLException {
        StudentSystem studentSystem = new StudentSystem();
        studentSystem.menu();
    }

}