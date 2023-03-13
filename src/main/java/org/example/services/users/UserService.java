package org.example.services.users;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.entity.User;

public interface UserService {
    void createUser(String login, String password);
    User getUserById(Integer id);
    void updateUserLogin(Integer id,String login);
    Integer deleteUserById(Integer id);
    User getUserRoleById(Integer id);
}
