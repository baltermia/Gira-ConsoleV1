package com.company;

import java.util.ArrayList;
import java.util.List;

public class employee {
    public List<employee> employeeList = new ArrayList<>();

    int id;
    String username;

    public employee(String username) {
        id = employeeList.size();
        this.username = username;
        gira.girObj.proObj.mainEmployee.employeeList.add(this);
    }

    public employee getEmployee(String id_username) {
        if (id_username.matches("[0-9]+")) {
            for (int i = 0; i < employeeList.size(); i++) {
                if (Integer.toString(employeeList.get(i).id).equals(id_username))
                    return employeeList.get(i);
            }
        } else {
            for (int i = 0; i < employeeList.size(); i++) {
                if (employeeList.get(i).username.equals(id_username)) return employeeList.get(i);
            }
        }
        return null;
    }
}