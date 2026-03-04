package rvt;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TodoList {
    private ArrayList<String> saraksts = new ArrayList<>();
    private final String filePath = "src/main/java/rvt/todo.csv";

    public TodoList() {
        this.saraksts = new ArrayList<>();
        loadFromFile();
    }

    public void print() {
        int i = 1;
        for (String list : saraksts) {
            System.out.println(i + ". " + list);
            i++;
        }
    }

    private void loadFromFile() {
        try (Scanner reader = new Scanner(new File(filePath))) {
            reader.nextLine(); // Ignore header row
            while (reader.hasNextLine()) {
                saraksts.add(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public int getLastId() {
        int skaititajs = 0;
        String x = saraksts.get(skaititajs);
        String[] masivsID = x.split(",");
        try (Scanner reader = new Scanner(new File(filePath))) {

            reader.nextLine(); // Ignore header line
            while (reader.hasNextLine()) {
                skaititajs++;
                reader.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        

        return Integer.valueOf(masivsID[0]);
    }

    public void add(String task) {
        saraksts.add(task);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {

            bw.write(getLastId() + 1 + "," + task);
            bw.newLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String uzd : saraksts) {
                bw.write(uzd);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(int id) {
        try (Scanner reader = new Scanner(new File(filePath))) {
            reader.nextLine(); // Ignore header line
            int index = 0;
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(",");
                if (Integer.valueOf(parts[0]) == id) {
                    saraksts.remove(index);
                    updateFile();
                }
                index++;
            }
        } catch (FileNotFoundException e) {

        }
    }
}
