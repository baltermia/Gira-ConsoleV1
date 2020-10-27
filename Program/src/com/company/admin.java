package com.company;
import java.util.ArrayList;
import java.util.List;

public class admin {
    public static List<admin> adminList = new ArrayList<>();

    int id;
    String username;
    String password;

    public admin(String username, String password) {
        id = adminList.size();
        this.username = username;
        this.password = password;
        adminList.add(this);
    }

    public static employee createEmployeeAccount(String name) {

        return new employee(getNewUsername(name, false));
    }

    public static admin createAdminAccount(String name, String password) {
        return new admin (getNewUsername(name, true), password);
    }

    public static boolean deleteEmployeeAccount(employee acc) {
        for (int i = 0; i < employee.employeeList.size(); i++) {
            if (employee.employeeList.get(i).equals(acc))
            {
                employee.employeeList.remove(i);
                return true;
            }
        }
        return false;
    }

    public static boolean deleteAdminAccount(admin acc) {
        for (int i = 0; i < employee.employeeList.size(); i++) {
            if (admin.adminList.get(i).equals(acc))
            {
                admin.adminList.remove(i);
                return true;
            }
        }
        return false;    }

    private static String getNewUsername(String name, boolean isAdmin) {
        String username = (name.substring(0, 3) + name.split(" ")[1].substring(0, 3)).toLowerCase();

        while (true) {
            if ((isAdmin == false ? employee.getEmployee(username) : getAdmin(username)) != null) {
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

    public static admin getAdmin(String id_username) {
        if (id_username.matches("[0-9]+")) {
            for (int i = 0; i < adminList.size(); i++) {
                if (Integer.toString(adminList.get(i).id).equals(id_username))
                    return adminList.get(i);
            }
        } else {
            for (int i = 0; i < adminList.size(); i++) {
                if (adminList.get(i).username.equals(id_username)) return adminList.get(i);
            }
        }
        return null;
    }
}
