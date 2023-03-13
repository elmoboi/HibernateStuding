package org.example;

import org.example.repositories.UserRepository;
import org.example.repositories.UserTaskRepository;
import org.example.services.role.UserTaskService;
import org.example.services.role.impl.UserTaskServiceImpl;
import org.example.services.users.UserService;
import org.example.services.users.impl.UserServiceImpl;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        UserRepository userRepository = new UserRepository(session);
        UserService userService = new UserServiceImpl(userRepository);
        UserTaskRepository userTaskRepository = new UserTaskRepository(session);
        UserTaskService userTaskService = new UserTaskServiceImpl(userTaskRepository);

        userService.createUser("qwe2","test2");
        userTaskService.addTaskToUserById("Сделать микросервис","2023-03-13 12:30",1);
        System.out.println(userTaskService.getUserTasksById(1));
    }
}