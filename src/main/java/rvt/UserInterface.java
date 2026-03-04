package rvt;

import java.util.*;

public class UserInterface {

    private TodoList list;
    private Scanner reader;
    final String TASK_ReGEX = "^[A-Za-z]+$";


    public UserInterface(TodoList list, Scanner reader) {
        this.list = list;
        this.reader = reader;
    }

    
    public void start() {
        while (true) {
            System.out.print("Command: ");
            String command = reader.nextLine();
            
                if (command.equals("stop")) {
                    break;
                } else if (command.equals("add")) {
                    System.out.print("To add: ");
                    list.add(reader.nextLine());
                } else if (command.equals("list")) {
                    list.print();
                } else if (command.equals("remove")) {
                    System.out.print("Which one is removed? ");
                    list.remove(Integer.valueOf(reader.nextLine()));
                }
            
        }
    }
}
