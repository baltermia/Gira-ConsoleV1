package com.company;

import java.io.IOException;

public class gira {

    public static void main(String[] args) throws IOException {
        navigation nav = new navigation();
        while (true) {
            System.out.println("Wilkommen in Gira. Bitte melden Sie sich an.");
            System.out.println("- 1: Employee Login\n- 2: Admin Login\n- 3: Beenden");

            String input = "";
            boolean active = false;

            do {
                if (active) System.out.println("Bitte geben Sie eine Zahl von 1-3 ein.");
                input = nav.reader.readLine();

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

            int inputNum = Integer.parseInt(input);

            if (inputNum == 1) nav.loginAsEmployee();
            else if (inputNum == 2) nav.loginAsAdmin();
            else if (inputNum == 3) break;
        }

        while (true) {
            System.out.println("Wilkommen in Gira. Bitte wählen Sie eine der folgenden Funktionen aus: (um eine Funktion abzubrechen schreiben Sie jederzeit EXIT");
            System.out.println("- 1: Create Ticket\n- 2: View Ticket\n- 3: Beenden");

            String input = "";
            boolean active = false;

            do {
                if (active) System.out.println("Bitte geben Sie eine Zahl von 1-3 ein.");
                input = nav.reader.readLine();

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

            int inputNum = Integer.parseInt(input);

            if (inputNum == 1) nav.createTicket();
            else if (inputNum == 2) nav.viewTicket();
            else if (inputNum == 3) break;
        }
        System.out.println("Programm wurde beendet.");
    }
}
