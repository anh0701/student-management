package org.example;

import java.util.Scanner;

public class StudentSystem {

    private static final StudentRepository studentRepository= new StudentManagement();
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
                        StudentEntity studentEntity = createStudentFromStdio();
//                        System.out.println(student.toString());
                        add(studentEntity);
                    }catch (Exception e){
                        e.printStackTrace(System.out);
                    }
                    break;
                case 2:
                    System.out.println("ID: ");
                    Integer delStudentId = sc.nextInt();
                    deleteById(delStudentId);
                    break;
                case 3:
                    System.out.println("ID: ");
                    Integer findStudentId = sc.nextInt();
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

    private StudentEntity createStudentFromStdio() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ID: ");
        Integer id = sc.nextInt();
        sc.nextLine();
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Age: ");
        Integer age = sc.nextInt();
        sc.nextLine();
        System.out.println("Gender: ");
        String gender = sc.nextLine();

        StudentEntity studentEntity = new StudentEntity(id, name, age, gender);
        
        return studentEntity;
    }

    public void displayStudentList() {
        for (StudentEntity studentEntity : studentRepository.getSTUDENT_ENTITIES().values()){
            System.out.println(studentEntity.toString());
        }
    }

    public void displayStudentById(Integer id) {
        if (studentRepository.findById(id) != null){
            System.out.println(studentRepository.findById(id));
        }else {
            System.out.println("Not found");
        }
    }

    public void deleteById(Integer id) {
       if (studentRepository.deleteById(id)){
           System.out.println("remove success");
       }else {
           System.out.println("Fail");
       }
    }

    public void add(StudentEntity studentEntity) {
        if (!studentRepository.add(studentEntity)){
            System.out.println("duplicate ID");
        } else{
            System.out.println("Success");
        }
    }
}
