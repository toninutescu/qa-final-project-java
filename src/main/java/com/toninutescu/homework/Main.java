package com.toninutescu.homework;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserRepository repository = new UserRepository();

        try {
            User user1 = new User("testuser", 25);
            repository.addUser(user1);
            System.out.println("User adaugat cu succes: " + user1.getUsername());
        } catch (InvalidUserDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            AdminUser admin = new AdminUser("adminuser", 30, "FULL_ACCESS");
            repository.addUser(admin);
            System.out.println("Admin adaugat cu succes: " + admin.getUsername());
        } catch (InvalidUserDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            User badUsername = new User("ab", 22);
            repository.addUser(badUsername);
            System.out.println("User adaugat: " + badUsername.getUsername());
        } catch (InvalidUserDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            User negativeAge = new User("baduser", -5);
            repository.addUser(negativeAge);
            System.out.println("User adaugat: " + negativeAge.getUsername());
        } catch (InvalidUserDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            repository.addUser(null);
        } catch (InvalidUserDataException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n Utilizatori validați");
        List<User> users = repository.getUsers();
        for (User u : users) {
            System.out.println("User: " + u.getUsername() + ", age=" + u.getAge());
        }
    }
}