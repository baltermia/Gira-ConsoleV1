package com.company;
import java.util.ArrayList;
import java.util.List;

public class admin {
    public List<admin> adminList = new ArrayList<>();

    int id;
    String username;
    String password;

    public admin(String username, String password) {
        id = adminList.size();
        this.username = username;
        this.password = password;

        if (!username.equals("admin")) {
            gira.girObj.proObj.rootAdmin.adminList.add(this);
        } else {
            this.adminList.add(this);
        }
    }

    public employee createEmployeeAccount(String name) {

        return new employee(getNewUsername(name, false));
    }

    public admin createAdminAccount(String name, String password) {
        return new admin (getNewUsername(name, true), password);
    }

    public boolean deleteEmployeeAccount(employee acc) {
        for (int i = 0; i < gira.girObj.proObj.employeeAccount.employeeList.size(); i++) {
            if (gira.girObj.proObj.employeeAccount.employeeList.get(i).equals(acc))
            {
                gira.girObj.proObj.employeeAccount.employeeList.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean deleteAdminAccount(admin acc) {
        for (int i = 0; i < gira.girObj.proObj.employeeAccount.employeeList.size(); i++) {
            if (gira.girObj.proObj.adminAccount.adminList.get(i).equals(acc))
            {
                gira.girObj.proObj.adminAccount.adminList.remove(i);
                return true;
            }
        }
        return false;    }

    private String getNewUsername(String name, boolean isAdmin) {
        String username = (name.substring(0, 3) + name.split(" ")[1].substring(0, 3)).toLowerCase();

        while (true) {
            if ((isAdmin == false ? gira.girObj.proObj.mainEmployee.getEmployee(username) : getAdmin(username)) != null) {
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

    public admin getAdmin(String id_username) {
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
