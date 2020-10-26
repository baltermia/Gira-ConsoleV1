package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystemLoopException;

public class navigation {
    public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int inputIndex(int end) throws IOException {
        boolean hasPassed = false;
        String input;
        int inputNum;
        while (true) {
            if (hasPassed)
                System.out.println("Bitte geben Sie eine Zahl von 1-" + end + " ein.");
            else
                hasPassed = true;

            input = reader.readLine();
            if (input.equals("EXIT"))
                return -1;

            if (input.matches("[0-9]+")) {
                inputNum = Integer.parseInt(input);
            } else {
                continue;
            }

            for (int i = 0; i < end; i++) {
                if (inputNum == i)
                    return inputNum;
            }
        }
    }

    public employee loginAsEmployee() throws IOException {
        System.out.println("Sie wollen sich als normaler Benutzer anmelden. Bitte geben Sie Ihren Benutzernamen oder Ihre Benutzer-ID ein:");
        while (true) {
            String input = reader.readLine();

            if (input.equals("EXIT")) {
                return null;
            }

            employee account = employee.getEmployee(input);

            if (account == null) {
                System.out.println("Ihr Account wurde nicht gefunden. Probieren Sie es nochmals: ");
                continue;
            } else {
                System.out.println("Ihr Account wurde gefunden. Sie sind nun angemeldet.");
                return account;
            }
        }
    }

    public admin loginAsAdmin() throws IOException {
        System.out.println("Sie wollen sich als Admin anmelden. Bitte geben Sie Ihren Benutzernamen oder Ihre Benutzer-ID ein:");
        while (true) {
            String input = reader.readLine();

            if (input.equals("EXIT"))
                return null;

            if (input == "EXIT") {
                return null;
            }

            admin account = admin.getAdmin(input);

            if (account == null) {
                System.out.println("Ihr Account wurde nicht gefunden. Probieren Sie es nochmals: ");
                continue;
            }

            System.out.println("Ihr Account wurde gefunden. Bitte geben Sie das Passwort ein:");
            while (true) {
                String password = reader.readLine();
                if (password.equals("EXIT"))
                    return null;

                if (account.password.equals(password)) {
                    System.out.println("Das eingegebene Passwort ist korrekt. Sie sind nun angemeldet.");
                    return account;
                } else {
                    System.out.println("Das eingegebene Passwort ist falsch. Versuchen Sie es nochmals:");
                    continue;
                }
            }
        }
    }

    // Create Account:
    void createAccount(boolean isAdmin) throws IOException {
        System.out.println("Bitte geben Sie Vor- und Nachnamen ein (keine zweiten Vornamen): ");

        String name;
        String password;

        while (true) {
            name = reader.readLine();
            if (name.equals("EXIT")) return;

            if (!name.equals("")) {
                if (name.contains(" ")) {
                    if (name.charAt(name.length() - 1) != ' ') {
                        if (name.split(" ")[0].length() < 3 || name.split(" ")[1].length() < 3 || name.split(" ")[1] == null) {
                            System.out.println("Ihr Vor- und Nachname müssen mindestens 3 Zeichen lange sein." +
                                    "\nVersuchen Sie es nochmal: ");
                            continue;
                        }
                    } else {
                        System.out.println("Das letzte Zeichen darf kein Leerzeichen sein." +
                                "\nVersuchen Sie es nochmal: ");
                        continue;
                    }
                } else {
                    System.out.println("Ihre Antwort muss mindestens 1 Leerzeichen enthalten." +
                            "\nVersuchen Sie es nochmal: ");
                    continue;
                }
            } else {
                System.out.println("Ihre Antwort darf nicht leer sein." +
                        "\nVersuchen Sie es nochmal: ");
                continue;
            }
            break;
        }

        if (isAdmin) {
            System.out.println("Bitte geben Sie ein Passwort ein: ");

            password = reader.readLine();
            if (password.equals("EXIT")) return;

            admin account = admin.createAdminAccount(name, password);

            System.out.println("Account wurde erfolgreich erstellt." +
                    "\nIhre Nutzername lautet: " + account.username +
                    "\nIhre Account-ID ist: " + account.id +
                    "\n-------------------------------");
        }
        else {
            employee account = admin.createEmployeeAccount(name);

            System.out.println("Account wurde erfolgreich erstellt." +
                    "\nIhre Nutzername lautet: " + account.username +
                    "\nIhre Account-ID ist: " + account.id +
                    "\n-------------------------------");
        }
    }

    void deleteAccount(boolean isAdmin) throws IOException {
        System.out.println("Bitte geben Sie den Benutzernamen oder die Benutzer-ID vom Account an, welchen Sie löschen wollen: ");

        while (true)
        {
            String input = reader.readLine();

            if (isAdmin) {
                admin acc = admin.getAdmin(input);
                if (acc == null) {
                    System.out.println("Der eingegebene Account wurde nicht gefunen. Bitte probieren Sie es nochmals:");
                    continue;
                }

                if (admin.deleteAdminAccount(acc)) {
                    System.out.print("Der Account wurde erfolgreich gelöscht.");
                } else {
                    System.out.println("Beim Löschen vom Account ist ein fehler aufgetreten. Abbruch.");
                }
                return;
            } else {
                employee acc = employee.getEmployee(input);

                if (employee.getEmployee(input) == null) {
                    System.out.println("Der eingegebene Account wurde nicht gefunen. Bitte probieren Sie es nochmals:");
                    continue;
                }

                if (admin.deleteEmployeeAccount(acc)) {
                    System.out.print("Der Account wurde erfolgreich gelöscht.");
                } else {
                    System.out.println("Beim Löschen vom Account ist ein fehler aufgetreten. Abbruch.");
                }
                return;
            }
        }
    }

    void createTicket() throws IOException {
        System.out.println("Wie soll Ihr Ticket heissen?");
        String name = reader.readLine();

        System.out.println("Was soll in die Ticket-Beschreibung geschrieben werden?");
        String desc = reader.readLine();

        System.out.println("Was für eine Priorität hat das Ticket?");
        System.out.println("- 1: Low\n- 2: Medium\n- 3: High");
        String priority = "";
        int input = inputIndex(3);
        switch(input) {
            case 1:
                priority = "Low";
                break;
            case 2:
                priority = "Medium";
                break;
            case 3:
                priority = "High";
                break;
        }

        System.out.println("Welcher Nutzer ist der Bearbeiter? (id/username)");
        employee editor;
        while (true) {
            String user = reader.readLine();
            if (employee.getEmployee(user) == null) {
                System.out.println("Es wurde keine Nutzer mit den Angaben gefunden. Bitte probieren Sie es nochals:");
                continue;
            }
            else {
                editor = employee.getEmployee(user);
            }
            break;
        }

        new ticket(name, desc, priority, null, editor);
    }

    // View Ticket:
    void viewTicket() throws IOException {

    }
}
