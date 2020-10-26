package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class navigation {
    public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int inputIndex(String input, int start, int end) throws IOException {
        boolean active = false;

        do {
            if (active) System.out.println("Bitte geben Sie eine Zahl von " + start + "-" + end + " ein.");
            input = reader.readLine();

            switch (input) {
                case "1":
                case "2":
                case "3":
                    active = false;
                    break;
                default:
                    active = true;
            }
        } while (active);

        return Integer.parseInt(input);
    }

    public employee loginAsEmployee() {
        return null;
    }

    public admin loginAsAdmin() {
        return null;
    }

    //ToDo:
    public void addEmployee() throws IOException {

    }

    // Create Account:
    void createAccount() throws IOException {
        System.out.println("Wollen Sie einen Admin oder Employee Account erstellen?");
        System.out.println("- 1: Admin\n- 2: Employee");
        boolean isAdmin = false;
        switch(inputIndex(reader.readLine(), 1, 3)) {
            case 1:
                isAdmin = true;
            case 2:
                isAdmin = false;
        }

        System.out.println("Bitte geben Sie ihren Vor- und Nachnamen ein (keine zweiten Vornamen): ");
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

    // Create Ticket:
    void createTicket() throws IOException {
        System.out.println("Wie soll Ihr Ticket heissen?");
        String name = reader.readLine();

        System.out.println("Was soll in die Ticket-Beschreibung geschrieben werden?");
        String desc = reader.readLine();

        System.out.println("Was für eine Priorität hat das Ticket?");
        System.out.println("- 1: Low\n- 2: Medium\n- 3: High");
        String priority = reader.readLine();
    }

    // View Ticket:
    void viewTicket() throws IOException {

    }
}
