package com.jeonguk;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;

@Controller("/users")
public class UserController {

    private final GsonConverter gsonConverter;

    @Inject
    public UserController(GsonConverter gsonConverter) {
        this.gsonConverter = gsonConverter;
    }

    @Get
    public String getUser() {
        User user = new User();
        user.setFirstName("Jeonguk");
        user.setLastName("Lee");
        return gsonConverter.toJson(user);
    }

}
