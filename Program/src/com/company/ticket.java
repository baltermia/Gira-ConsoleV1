package com.company;

import java.util.ArrayList;
import java.util.List;


public class ticket {
    public static List<ticket> ticketList = new ArrayList<>();

    int id;
    String name;
    String description;
    String priority;


    ticket(String name, String description, String priority) {
        id = ticketList.size();
        this.name = name;
        this.description = description;
        this.priority = priority;
        ticketList.add(this);
    }
}
