package com.incubyte;

import javax.transaction.Transactional;

public class UserService {

    UserRepository userRepository = new UserRepository();

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }
}
