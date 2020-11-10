package dev.cosmingherghe.rest.webservices.restfulwebservices.services;

import dev.cosmingherghe.rest.webservices.restfulwebservices.users.Post;
import dev.cosmingherghe.rest.webservices.restfulwebservices.users.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static Integer usersCount = 3;

    static {
        users.add(new User(0, "Adam", new Date()));
        users.add(new User(1, "Eve", new Date()));
        users.add(new User(2, "Jack", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if(user.getId() == null) {
            user.setId(++usersCount);
        }

        users.add(user);

        return user;
    }

    public User findUserById(int id) {
        for(User user:users)
            if(user.getId() == id) {
                return user;
        }
        return null;
    }

    public User deleteUserById(int id) {

        if(users.get(id) != null) {
            User user = users.get(id);
            users.remove(user);
            return user;
        }

        return null;
    }
}