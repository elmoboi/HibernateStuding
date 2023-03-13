package org.example.services.role.impl;

import org.example.entity.UserTask;
import org.example.repositories.UserTaskRepository;
import org.example.services.role.UserTaskService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class UserTaskServiceImpl implements UserTaskService {

    UserTaskRepository userTaskRepository;
    public UserTaskServiceImpl(UserTaskRepository userTaskRepository){
        this.userTaskRepository = userTaskRepository;
    }

    @Override
    public List<UserTask> getUserTasksById(Integer id) {
        return userTaskRepository.getUserTasksById(id);
    }

    @Override
    public void addTaskToUserById(String task, String deadline, Integer id) {
        userTaskRepository.addTaskToUserById(task,deadline,id);
    }

    @Override
    public void deleteTaskFromUserById(Integer id) {
        userTaskRepository.deleteTaskFromUserById(id);
    }
}
