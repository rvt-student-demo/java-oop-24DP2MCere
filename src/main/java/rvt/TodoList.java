package rvt;

import java.util.ArrayList;

public class TodoList {
    ArrayList<String> saraksts = new ArrayList<>();

    public void add(String task){
       
        saraksts.add(task);
    }

    public void print(){
        int i = 1;
        for(String list : saraksts){
            System.out.println(i + ". " + list );
            i ++;
        }
    }

    public void remove(int number){
        saraksts.remove(--number);
    } 
}
