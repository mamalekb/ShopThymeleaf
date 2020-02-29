package pl.edu.wszib.dao.impl;


import org.springframework.stereotype.Repository;
import pl.edu.wszib.dao.UserDao;
import pl.edu.wszib.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    private Map<Long, User> userMap;
    private static Long id = 1L;

    public UserDaoImpl() {
        this.userMap = new HashMap<>();
        prepareUserList();
    }



    @Override
    public List<User> getUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() < 1) {
            user.setId(id);
            id++;
        }
        userMap.put(user.getId(), user);
    }

    @Override
    public void removeUser(Long id) {
        userMap.remove(id);
    }

    @Override
    public User getById(Long id) {
        return userMap.get(id);
    }

    private void prepareUserList() {
        User user = new User();
        user.setLogin("Użytkownik 1");
        user.setEmail("użytkownik1@gmail.com");
        user.setAge(21);
        user.setCountry("Polska");
        user.setActive(true);
        saveUser(user);

        User user2 = new User();
        user2.setLogin("Użytkownik 2");
        user2.setEmail("użytkownik2@gmail.com");
        user2.setAge(34);
        user2.setCountry("Francja");
        user2.setActive(false);
        saveUser(user2);

        User user3 = new User();
        user3.setLogin("Użytkownik 3");
        user3.setEmail("użytkownik3@gmail.com");
        user3.setAge(45);
        user3.setCountry("Kanada");
        user3.setActive(true);
        saveUser(user3);
    }
}
