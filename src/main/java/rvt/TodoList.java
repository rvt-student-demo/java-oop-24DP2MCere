package rvt;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TodoList {
    ArrayList<String> saraksts = new ArrayList<>();
    private final String filePath = "src/main/java/rvt/todo.csv";
    private int id;


    public TodoList() {
        this.saraksts = new ArrayList<>();
    }


    public void print() {
        int i = 1;
        for (String list : saraksts) {
            System.out.println(i + ". " + list);
            i++;
        }
    }


    public void loadFromFile() {
        try (Scanner reader = new Scanner(new File(filePath))) {
            while (reader.hasNextLine()) {
                saraksts.add(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public int getLastId() {
        int skaititajs = 0;
        try (Scanner reader = new Scanner(new File(filePath))) {
            reader.nextLine(); // Ignore header line
            while (reader.hasNextLine()) {
                skaititajs++;
                reader.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return skaititajs;
    }


    public void add(String task) {
        int ID = getLastId() + 1 ;
        saraksts.add(ID + "," + task);
        updateFile();
    }


    public void updateFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String uzd : saraksts){
                bw.write(uzd);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void remove(int id) {
        this.id = 0;
        try (Scanner reader = new Scanner(new File(filePath))) {
            reader.nextLine(); // Ignore header line
            while (reader.hasNextLine()) {
                this.id++;
                
                if (this.id == id) {
                    saraksts.remove(id);
                    updateFile();
                }
                reader.nextLine();
            }
        } catch (FileNotFoundException e) {
            
        }
    }
}
