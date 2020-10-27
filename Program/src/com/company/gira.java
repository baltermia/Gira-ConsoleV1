package com.company;

import java.io.IOException;

public class gira {
    public static boolean accountIsAdmin = false;
    public static employee employeeAccount = null;
    public static admin adminAccount = null;

    public static void main(String[] args) throws IOException {
        new admin("admin", "root");

        navigation nav = new navigation();
        boolean endProgram = false;

        while (!endProgram) {
            while (true) {
                System.out.println("Wilkommen in Gira. Bitte melden Sie sich an.");
                System.out.println("- 1: Employee Login\n- 2: Admin Login\n- 3: Beenden");

                int inputNum = nav.inputIndex(3);

                if (inputNum == 1) {
                    employeeAccount = nav.loginAsEmployee();
                    accountIsAdmin = false;
                }
                else if (inputNum == 2) {
                    adminAccount = nav.loginAsAdmin();
                    accountIsAdmin = true;
                }
                else if (inputNum == 3 || inputNum == -1)
                {
                    endProgram = true;
                    break;
                }

                if (employeeAccount == null && adminAccount == null) {
                    endProgram = true;
                    break;
                } else {
                    break;
                }
            }

            if (endProgram)
                break;

            if (accountIsAdmin) {
                while (true) {
                    System.out.println("\nWilkommen " + adminAccount.username + ". Sie sind als Admin angemeldet. Bitte wählen Sie eine der folgenden Funktionen aus: (um eine Funktion abzubrechen schreiben Sie jederzeit EXIT");
                    System.out.println("- 1: Employee Account erstellen\n- 2: Admin Account erstellen\n- 3: Employee Account löschen\n- 4: Admin Account löschen\n- 5: Abmelden");

                    int inputNum = nav.inputIndex(6);

                    if (inputNum == 1) nav.createAccount(false);
                    else if (inputNum == 2) nav.createAccount(true);
                    else if (inputNum == 3) nav.deleteAccount(false);
                    else if (inputNum == 4) nav.deleteAccount(true);
                    else if (inputNum == 6); //TODO: Balter wenn du break; machsch den gots ni uf dia letscht Zahl wo ahgisch, sondern uf dia Zweitletschti.
                }
            } else {
                while (true) {
                    System.out.println("\nWilkommen " + employeeAccount.username + ". Sie sind als normaler Benutzer angemeldet. Bitte wählen Sie eine der folgenden Funktionen aus: (um eine Funktion abzubrechen schreiben Sie jederzeit EXIT");
                    System.out.println("- 1: Ticket erstellen\n- 2: Ticket ansehen\n- 3: Abmelden");

                    int inputNum = nav.inputIndex(3);

                    if (inputNum == -1) {
                        endProgram = true;
                        break;
                    }

                    if (inputNum == 1) nav.createTicket();
                    else if (inputNum == 2) nav.viewTicket();
                    else if (inputNum == 3) break;
                }
            }
        }

        System.out.println("Programm wurde beendet. Danke dass Sie Gira nutzen.");
    }
}
