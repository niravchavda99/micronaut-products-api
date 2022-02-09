package com.incubyte;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

@Controller("/users")
public class UserController {
    UserService userService = new UserService();

    @Get
    public String getUsers() {
        return "Happy Birthday";
    }

    @Post
    public User save(@Body User user) {
        return userService.save(user);
    }
}
