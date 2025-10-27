package com.toninutescu.homework;

import java.util.Scanner;

public class UsernameValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username;

        do {
            System.out.print("Introdu un username: ");
            username = scanner.nextLine();

            // 1: Lungimea sa fie intre 6 si 12 caractere (If length <6 sau > 12 -> False))
            if (username.length() < 6 || username.length() > 12) {
                System.out.println("Eroare: Username-ul trebuie sa aiba intre 6 si 12 caractere.");
                continue;
                // sare peste ceilalti pasi pentru userul scris si se reia cererea de introducerea unui nou user
            }

            // 2: Userul sa nu contina spatii
            if (username.contains(" ")) {
                System.out.println("Eroare: Username-ul nu poate contine spatii.");
                continue; // sare peste ceilalti pasi pentru userul scris si se reia cererea de introducerea unui nou user
            }

            // 3: userul trebuie sa contina cel putin o cifra
            boolean HasDigit = false; //initializare cu false
            for (int i = 0; i < username.length(); i++) {
                if (Character.isDigit(username.charAt(i)))
                {
                    HasDigit = true;
                    break; //Opreste executia buclei For
                }
            }
            if (!HasDigit)  //Daca nu contine cifra
            {
                System.out.println("Eroare: Username-ul trebuie sa contina cel putin o cifra.");
                continue; // sare peste ceilalti pasi pentru userul scris si se reia cererea de introducerea unui nou user
            }

            // Daca a trecut peste toti pasii de verificare
            System.out.println("Username acceptat: " + username);
            break;

        } while (true);

        scanner.close();
    }
}