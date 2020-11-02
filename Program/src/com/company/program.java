package com.company;

import java.io.IOException;

/**
 * Ersetzt gira.java, da sonst statisch.
 */
public class program {
    public boolean accountIsAdmin = false;
    public employee employeeAccount = null;
    public admin adminAccount = null;

    public admin rootAdmin = new admin("admin", "root");
    public employee mainEmployee = new employee("standardUser");
    public ticket startupTicket = new ticket("Gira", "Wilkommen bei Gira", "-", mainEmployee, mainEmployee);
    public logger logger = new logger(new logger("").getFilePath());

    /**
     * Ersetzt die Main Methode von gira, da sonsts statisch
     */
    public void run() {
        try {
            gira.girObj.proObj.logger.log("Programm gestartet.");

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
                    else if (inputNum == 3)
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
                        System.out.println("\nWilkommen " + adminAccount.username + ". Sie sind als Admin angemeldet. Bitte wählen Sie eine der folgenden Funktionen aus: ");
                        System.out.println("- 1: Employee Account erstellen\n- 2: Admin Account erstellen\n- 3: Employee Account löschen\n- 4: Admin Account löschen\n- 5: Abmelden");

                        int inputNum = nav.inputIndex(5);

                        if (inputNum == 1) nav.createAccount(false);
                        else if (inputNum == 2) nav.createAccount(true);
                        else if (inputNum == 3) nav.deleteAccount(false);
                        else if (inputNum == 4) nav.deleteAccount(true);
                        else if (inputNum == 5) break;
                    }
                } else {
                    while (true) {
                        System.out.println("\nWilkommen " + employeeAccount.username + ". Sie sind als normaler Benutzer angemeldet. Bitte wählen Sie eine der folgenden Funktionen aus: (um eine Funktion abzubrechen schreiben Sie jederzeit EXIT");
                        System.out.println("- 1: Ticket erstellen\n- 2: Ticket ansehen\n- 3: Abmelden");

                        int inputNum = nav.inputIndex(3);

                        if (inputNum == 1) nav.createTicket();
                        else if (inputNum == 2) nav.viewTicket();
                        else if (inputNum == 3) break;
                    }
                }
            }
            gira.girObj.proObj.logger.log("Programm wurde beendet");
            System.out.println("Programm wurde beendet. Danke dass Sie Gira nutzen.");
        }
        catch(Exception ex)  {
            System.out.println("Es gab einen unbekannten Fehler. Program wird beendet.");
            try {
                gira.girObj.proObj.logger.log(ex.getMessage());
            }
            catch (Exception e) {
                System.out.println("Fehlermeldung Konnte nicht in die Log-Datei geschrieben werden. Ausgabe in der Konsole:\n" + e.getMessage());
            }
        }
    }
}
