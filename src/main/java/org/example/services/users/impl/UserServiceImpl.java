package org.example.services.users.impl;

import org.example.entity.User;
import org.example.repositories.UserRepository;
import org.example.services.users.UserService;

public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(String login, String password) {
        userRepository.createUser(login, password);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void updateUserLogin(Integer id, String login) {
        userRepository.updateUserLogin(id, login);
    }

    @Override
    public Integer deleteUserById(Integer id) {
        return userRepository.deleteUserById(id);
    }

    @Override
    public User getUserRoleById(Integer id) {
        return userRepository.getUserRoleById(id);
    }
}
