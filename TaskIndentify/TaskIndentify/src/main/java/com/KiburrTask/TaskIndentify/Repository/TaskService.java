package com.KiburrTask.TaskIndentify.Repository;

import com.KiburrTask.TaskIndentify.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task CreateTask(Task task);
    Task UpdateTask(Task task);
    Optional<Task> GetTaskByTaskId(String taskId);
    Optional<Task> GetTaskByTaskName(String taskName);
    List<Task> GetAllTask();
    List<Task> getTop10ByTaskAssignee(String taskAssignee);
    void DeleteTaskByTaskId(String taskId);
}
