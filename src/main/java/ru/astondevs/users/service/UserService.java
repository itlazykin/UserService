package ru.astondevs.users.service;

import ru.astondevs.users.dao.SimpleUserDao;
import ru.astondevs.users.model.User;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final SimpleUserDao userDao;

    public UserService(SimpleUserDao userDao) {
        this.userDao = userDao;
    }

    public User createUser(String name, String email, int age) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setAge(String.valueOf(age));

        Long userId = userDao.save(user);
        return userDao.findById(userId);
    }

    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(userDao.findById(id));
    }

    public Optional<User> updateUser(Long id, String name, String email, Integer age) {
        User user = userDao.findById(id);
        if (user == null) {
            return Optional.empty();
        }
        if (name != null) {
            user.setName(name);
        }
        if (email != null) {
            user.setEmail(email);
        }
        if (age != null) {
            user.setAge(String.valueOf(age));
        }
        return userDao.update(user) ? Optional.of(user) : Optional.empty();
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public boolean deleteUser(Long id) {
        return userDao.deleteById(id);
    }
}
