package com.toninutescu.homework;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private List<User> users = new ArrayList<>();

    public void addUser(User user) throws InvalidUserDataException {
        if (user == null) {
            throw new InvalidUserDataException("Avertisment: Valoarea 'null' nu este un utilizator valid si va fi ignorata.");
        }

        if (user.getUsername() == null || user.getUsername().length() < 3) {
            String valoare = user == null ? "null" : user.getUsername();
            throw new InvalidUserDataException("Avertisment: Valoarea '" + valoare + "' nu este un nume valid si va fi ignorata.");
        }

        if (user.getAge() < 0) {
            throw new InvalidUserDataException("Avertisment: Valoarea '" + user.getAge() + "' nu este o varsta valida si va fi ignorata.");
        }

        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}