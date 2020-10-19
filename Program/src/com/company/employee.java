package com.company;

public class employee {
    int id;
    String username;
    String password;
    Boolean isAdmin;

    employee(String username, String password, Boolean admin) {
        id = manager.employeeList.size();
        this.username = username;
        this.password = password;
        isAdmin = admin;
        manager.employeeList.add(this);
    }

    public static employee getEmployee(String id_username) {
        if (id_username.matches("[0-9]+")) {
            for (int i = 0; i < manager.employeeList.size(); i++) {
                if (Integer.toString(manager.employeeList.get(i).id).equals(id_username))
                    return manager.employeeList.get(i);
            }
        } else {
            for (int i = 0; i < manager.employeeList.size(); i++) {
                if (manager.employeeList.get(i).username.equals(id_username)) return manager.employeeList.get(i);
            }
        }
        return null;
    }

    public static employee createAccount(String name, String password) {
        String username = (name.substring(0, 3) + name.split(" ")[1].substring(0, 3)).toLowerCase();

        while (true) {
            if (getEmployee(username) != null) {
                if (username.length() > 6) {
                    int strLenth = username.length();
                    while (strLenth > 0 && Character.isDigit(username.charAt(strLenth - 1))) {
                        strLenth--;
                    }
                    int endNumber = Integer.parseInt(username.substring(strLenth));

                    username = username.substring(0, username.length() - String.valueOf(endNumber).length()) + (endNumber + 1);
                } else {
                    username += "1";
                }
            } else {
                break;
            }
        }
        return new employee(username, password, false);
    }
}