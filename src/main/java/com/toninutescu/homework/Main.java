package com.toninutescu.homework;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserRepository repository = new UserRepository();

        // date de intrare
        String[] usernames = {"testuser", "adminuser", "ab", "baduser", null};
        int[] ages         = {25, 30, 22, -5, 20};
        boolean[] isAdmin  = {false, true, false, false, false};

        // verificare date intrare
        for (int i = 0; i < usernames.length; i++) {
            try {
                User user;

                if (isAdmin[i]) {
                    // la Admin se adauga permisiune
                    user = new AdminUser(usernames[i], ages[i], "FULL_ACCESS");
                } else {
                    user = new User(usernames[i], ages[i]);
                }

                repository.addUser(user);
                System.out.println("User inregistrat: " + user.getUsername() + " (age=" + user.getAge() + ")");
            } catch (InvalidUserDataException e) {
                // afișam mesajul din excepție daca exista
                System.out.println(e.getMessage());
            }
        }

        // afișam doar utilizatorii care au trecut validarile
        System.out.println("\n Utilizatori validati");
        List<User> users = repository.getUsers();
        for (User u : users) {
            System.out.println("User: " + u.getUsername() + ", age=" + u.getAge());
        }
    }
}