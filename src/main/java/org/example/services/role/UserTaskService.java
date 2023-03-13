package org.example.services.role;

import org.example.entity.UserTask;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface UserTaskService {
    List<UserTask> getUserTasksById(Integer id);
    void addTaskToUserById(String task, String deadline, Integer id);
    void deleteTaskFromUserById(Integer id);

}
