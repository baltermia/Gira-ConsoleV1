package com.company;

public class employee {
    int id;
    String username;
    String password;
    Boolean isAdmin;

    employee(String username, String password, Boolean admin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAdmin = admin;
        manager.employeeList.add(this);
    }

    public static employee getEmployee(String id) {
        if (id.matches("[0-9]+")) {
            for (int i = 0; i < manager.employeeList.size(); i++) {
                if (Integer.toString(manager.employeeList.get(i).id).equals(id)) return manager.employeeList.get(i);
            }
        } else {
            for (int i = 0; i < manager.employeeList.size(); i++) {
                if (manager.employeeList.get(i).username.equals(id)) return manager.employeeList.get(i);
            }
        }
        return null;
    }
}