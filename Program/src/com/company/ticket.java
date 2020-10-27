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


    public ticket(String name, String description, String priority, employee reporter, employee editor) {
        id = ticketList.size();
        this.name = name;
        this.description = description;
        this.priority = priority;
        isSolved = false;
        this.reporter = reporter;
        this.editor = editor;
        ticketList.add(this);
    }

    public static ticket getTicket(String id) {
        if (id.matches("[0-9]+")) {
            for (int i = 0; i < ticketList.size(); i++) {
                if (Integer.toString(ticketList.get(i).id).equals(id))
                    return ticketList.get(i);
            }
        }
        return null;
    }
}
