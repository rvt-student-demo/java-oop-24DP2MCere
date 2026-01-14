package rvt;
import java.util.*;
public class MainProg {
    public static void main(String[] args){
    TodoList todo = new TodoList();
    Scanner reader = new Scanner(System.in);
    UserInterface user = new UserInterface(todo, reader);

    user.start();
    }
}
