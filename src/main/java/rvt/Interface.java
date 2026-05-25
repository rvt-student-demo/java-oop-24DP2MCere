package rvt;

import java.util.Scanner;

public class Interface {
    private Student student;
    private Scanner reader;

    public Interface(Student student, Scanner reader) {
        this.student = student;
        this.reader = reader;
    }

    public void start() {
        while (true) {
            System.out.println("1. Register a student");
            System.out.println("2. Show all students");
            System.out.println("3. Remove a student");
            System.out.println("4. Edit a student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            String choice = reader.nextLine();
            switch (choice) {
                case "1":
                    student.register();
                    break;
                case "2":
                    student.show();
                    break;
                case "3":
                   student.remove();
                    break;
                case "4":
                   student.edit();
                    break;
                case "5":
                   return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
   
   
}

