package rvt;

import java.util.Scanner;

public class Main {

    public static void main(String[] a) {
        Scanner scanner = new Scanner(System.in);
        Student Studentu_regx = new Student(scanner);
        Interface userInterface = new Interface(Studentu_regx, scanner);

        userInterface.start();
    }

    
}
