package com.company;

import java.util.ArrayList;
import java.util.List;


public class ticket {
    public static List<ticket> ticketList = new ArrayList<>();

    int id;
    String name;
    String description;
    String priority;
    boolean isSolved;
    employee editor;
    employee reporter;


    ticket(String name, String description, String priority, employee reporter, employee editor) {
        id = ticketList.size();
        this.name = name;
        this.description = description;
        this.priority = priority;
        isSolved = false;
        this.reporter = reporter;
        this.editor = editor;
        ticketList.add(this);
    }
}
