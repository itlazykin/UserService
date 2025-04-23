package ru.astondevs.users.service;

import ru.astondevs.users.model.User;

import java.util.List;

public interface UserService {
    Long save(User user);

    User findById(Long id);

    List<User> findAll();

    boolean update(User user);

    void delete(User user);

    boolean deleteById(Long id);
}
