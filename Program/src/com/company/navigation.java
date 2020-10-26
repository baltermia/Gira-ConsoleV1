package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class navigation {
    public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public employee loginAsEmployee() {
        return null;
    }

    public admin loginAsAdmin() {
        return null;
    }

    //ToDo:
    void addEmployee() throws IOException {

    }

    //ToDo:
    void addGroup() throws IOException {

    }

    // Create Account:
    void createAccount() throws IOException {
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

        System.out.println("Bitte geben Sie ein Passwort ein: ");

        password = reader.readLine();
        if (password.equals("EXIT")) return;

        employee account = admin.createAccount(name, password);

        System.out.println("Account wurde erfolgreich erstellt." +
                "\nIhre Nutzername lautet: " + account.username +
                "\nIhre Account-ID ist: " + account.id +
                "\n-------------------------------");
    }

    // Create Ticket:
    void createTicket() throws IOException {

    }

    // View Ticket:
    void viewTicket() throws IOException {

    }
}
