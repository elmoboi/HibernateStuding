package org.example.repositories;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.entity.User;
import org.example.entity.UserTask;
import org.example.services.users.UserService;
import org.example.services.users.impl.UserServiceImpl;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UserTaskRepository {
    private final Session session;

    public UserTaskRepository(Session session) {
        this.session = session;
    }

    public List<UserTask> getUserTasksById(Integer id) {
        session.beginTransaction();
        String hql = "from UserTask where user.id = :id";
        Query<UserTask> query = session.createQuery(hql, UserTask.class);
        query.setParameter("id", id);
        List<UserTask> userTaskList = query.list();
        return userTaskList;
    }

    public void addTaskToUserById(String task, String deadline, Integer id){
        session.beginTransaction();
        UserTask userTask = new UserTask();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(deadline,dateTimeFormatter);
        UserRepository userRepository = new UserRepository(session);
        UserService userService = new UserServiceImpl(userRepository);
        User user = userService.getUserById(id);
        userTask.setUser(user);
        userTask.setTaskName(task);
        userTask.setDeadLine(localDateTime);
        session.persist(userTask);
        session.getTransaction().commit();
    }
    public void deleteTaskFromUserById(Integer id){

    }
}
