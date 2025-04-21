package ru.astondevs.users.dao;

import ru.astondevs.users.model.User;

import java.util.List;

public interface UserDao {
    Long save(User user);

    User findById(Long id);

    List<User> findAll();

    boolean update(User user);

    void delete(User user);

    boolean deleteById(Long id);
}
