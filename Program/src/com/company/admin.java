package com.company;
import java.util.ArrayList;
import java.util.List;

public class admin {
    public static List<admin> adminList = new ArrayList<>();

    int id;
    String username;
    String password;

    admin(String username, String password) {
        id = adminList.size();
        this.username = username;
        this.password = password;
        adminList.add(this);
    }

    public static employee createEmployeeAccount(String name) {

        return new employee(getNewUsername(name));
    }

    public static admin createAdminAccount(String name, String password) {
        return new admin (getNewUsername(name), password);
    }

    private static String getNewUsername(String name) {
        String username = (name.substring(0, 3) + name.split(" ")[1].substring(0, 3)).toLowerCase();

        while (true) {
            if (employee.getEmployee(username) != null) {
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

        return username;
    }
}
