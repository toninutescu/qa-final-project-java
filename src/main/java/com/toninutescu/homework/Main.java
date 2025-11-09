package com.toninutescu.homework;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserRepository repository = new UserRepository();

        // 1) User valid
        try {
            User user1 = new User("testuser", 25);
            repository.addUser(user1);
            System.out.println("User adaugat cu succes: " + user1.getUsername());
        } catch (InvalidUserDataException e) {
            System.out.println("Eroare la user valid: " + e.getMessage());
        }

        // 2) AdminUser valid
        try {
            AdminUser admin = new AdminUser("adminuser", 30, "FULL_ACCESS");
            repository.addUser(admin);
            System.out.println("Admin adaugat cu succes: " + admin.getUsername());
        } catch (InvalidUserDataException e) {
            System.out.println("Eroare la admin: " + e.getMessage());
        }

        // 3) Username prea scurt
        try {
            User badUsername = new User("ab", 22);
            repository.addUser(badUsername);
            System.out.println("User adaugat (nu ar trebui): " + badUsername.getUsername());
        } catch (InvalidUserDataException e) {
            System.out.println("Eroare asteptata (username prea scurt): " + e.getMessage());
        }

        // 4) Varsta negativa
        try {
            User negativeAge = new User("baduser", -5);
            repository.addUser(negativeAge);
            System.out.println("User adaugat (nu ar trebui): " + negativeAge.getUsername());
        } catch (InvalidUserDataException e) {
            System.out.println("Eroare asteptata (varsta negativa): " + e.getMessage());
        }

        // 5) User null
        try {
            repository.addUser(null);
            System.out.println("User null adaugat (nu ar trebui).");
        } catch (InvalidUserDataException e) {
            System.out.println("Eroare asteptata (user null): " + e.getMessage());
        }

        // Afisam doar utilizatorii care au trecut validarile
        System.out.println("\n=== Utilizatori validati si inregistrati ===");
        List<User> users = repository.getUsers();
        for (User u : users) {
            System.out.println("User: " + u.getUsername() + ", age=" + u.getAge());
        }
    }
}