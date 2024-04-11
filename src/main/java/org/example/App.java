package org.example;

import org.example.model.Passport;
import org.example.model.User;
import org.example.service.UserService;
import org.example.service.impl.UserServImpl;

/**
 * Hello world!
 */
public class App {
    private static final UserService USER_SERVICE = new UserServImpl();

    public static void main(String[] args) {
        Passport foreignPassport = new Passport("foreign_passport", 2);
        Passport innerPassport = new Passport("inner_passport", 9);

        User user = new User("user_name", "user_last_name", foreignPassport);
        User user2 = new User("user_name2", "user_last_name2", innerPassport);

        USER_SERVICE.save(user);
        USER_SERVICE.save(user2);
        // USER_SERVICE.deleteById(2L);
    }
}
