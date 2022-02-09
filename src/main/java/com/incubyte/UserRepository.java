package com.incubyte;

public class UserRepository {
    public User save(User user) {
        user.setName("From Repository");
        return user;
    }
}
