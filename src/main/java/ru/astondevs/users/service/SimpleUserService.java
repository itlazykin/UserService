package ru.astondevs.users.service;

import ru.astondevs.users.repository.SimpleUserRepository;
import ru.astondevs.users.model.User;

import java.util.List;

public class SimpleUserService implements UserService {
    private final SimpleUserRepository simpleUserRepository;

    public SimpleUserService(SimpleUserRepository simpleUserRepository) {
        this.simpleUserRepository = simpleUserRepository;
    }

    @Override
    public Long save(User user) {
        return simpleUserRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return simpleUserRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return simpleUserRepository.findAll();
    }

    @Override
    public boolean update(User user) {
        return simpleUserRepository.update(user);
    }

    @Override
    public void delete(User user) {
        simpleUserRepository.delete(user);
    }

    @Override
    public boolean deleteById(Long id) {
        return simpleUserRepository.deleteById(id);
    }
}
