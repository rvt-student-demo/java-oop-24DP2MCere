package rvt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private String name;
    private String surname;
    private String email;
    private String personasID;
    private Scanner reader;
    private ArrayList<String> saraksts = new ArrayList<>();
    final String FILE_PATH = "students.csv";

    public Student(Scanner reader) {
        this.saraksts = new ArrayList<>();
        this.reader = reader;
    }

    public void show() {
        System.out.println("+--------------+-----------------+---------------------------+--------------+");
        System.out.printf("| %-12s | %-15s | %-25s | %-12s |\n",
                "Name", "Surname", "Email", "Personas ID");
        System.out.println("+--------------+-----------------+---------------------------+--------------+");
        for (String student : this.saraksts) {
            System.out.printf("| %-12s | %-15s | %-25s | %-12s |\n",
                    student.split(" ")[0], student.split(" ")[1], student.split(" ")[2], student.split(" ")[3]);

        }
        System.out.println("+--------------+-----------------+---------------------------+--------------+");

    }

    public void remove() {
        System.out.println("Enter the Personas ID of the student to remove: ");
        String personasKods = reader.nextLine();
        boolean found = false;

        for (String student : this.saraksts) {
            String[] parts = student.split(" ");

            if (parts[3].equals(personasKods)) {
                saraksts.remove(student);
                System.out.println("Student removed.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No student found with Personas ID " + personasKods);
        };
    }

    public void edit() {
        System.out.println("Enter the Personas ID of the student to edit: ");
        String personasKods = reader.nextLine();

        for (String student : this.saraksts) {

            String[] parts = student.split(" ");

            if (parts[3].equals(personasKods)) {

                System.out.println("Enter your name: ");
                this.name = reader.nextLine();
                System.out.println("Enter your surname: ");
                this.surname = reader.nextLine();
                System.out.println("Enter your email: ");
                this.email = reader.nextLine();
                System.out.println("Enter your personas ID: ");
                this.personasID = reader.nextLine();
                String editedStudent = name + " " + surname + " " + email + " " + personasID;
                this.saraksts.set(this.saraksts.indexOf(student), editedStudent);
                break;
            }
        }

        System.out.println("No student found with Personas ID " + personasKods + ".");
    }

    //11

    public void register() {

        System.out.println("Enter your name: ");
        this.name = reader.nextLine();
        if(this.name.isEmpty()) {
            System.out.println("Name cannot be empty. Please try again.");
            this.name = reader.nextLine();

        }
        System.out.println("Enter your surname: ");
        this.surname = reader.nextLine();
        if(this.surname.isEmpty()) {
            System.out.println("Surname cannot be empty. Please try again.");
            this.surname = reader.nextLine();
        }
        System.out.println("Enter your email: ");
        this.email = reader.nextLine();
        if(this.email.isEmpty()) {
            System.out.println("Email cannot be empty. Please try again.");
            this.email = reader.nextLine();
        }
        for (String student : this.saraksts) {
            String[] parts = student.split(" ");
            if (parts[2].equals(this.email)) {
                System.out.println("A student with this email already exists.Please use a different email.");
                break;
            }
        }
        System.out.println("Enter your personas ID: ");
        this.personasID = reader.nextLine();
        if(this.personasID.isEmpty()) {
            System.out.println("Personas ID cannot be empty. Please try again.");
            this.personasID = reader.nextLine();
        }
        for (String student : this.saraksts) {
            String[] parts = student.split(" ");
            if (parts[3].equals(this.personasID)) {
                System.out.println("A student with this Personas ID already exists.");
                break;
            }
        }
        if (this.personasID.length() != 12) {
            System.out.println("Personas ID must be exactly 12 characters long. Please try again.");
            this.personasID = reader.nextLine();
        }
        String student = name + " " + surname + " " + email + " " + personasID;
        this.saraksts.add(student);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(student); // write the student information to the file
            writer.newLine(); // Add a new line after each student
            System.out.println("Student successfully registered!");
        } catch (java.io.IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());

        }

    }

}
