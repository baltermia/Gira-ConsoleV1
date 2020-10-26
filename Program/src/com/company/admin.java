package com.company;
import java.util.ArrayList;
import java.util.List;

public class admin {
    public static List<employee> adminList = new ArrayList<>();

    public static employee createAccount(String name, String password) {
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
        return new employee(username);
    }
}
