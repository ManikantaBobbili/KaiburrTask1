package com.KiburrTask.TaskIndentify.Repository;

import com.KiburrTask.TaskIndentify.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task CreateTask(Task task) {
        String generatedPropertyValue = generatePropertyValue();
        task.setManikantaBobbiliProperty(generatedPropertyValue);
        return taskRepository.save(task);
    }

    private String generatePropertyValue() {
        String candidateName = "ManikantaBobbili";
        Random random = new Random();
        StringBuilder propertyValue = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(candidateName.length());
            propertyValue.append(candidateName.charAt(index));
        }
        return propertyValue.toString();
    }

    @Override
    public Task UpdateTask(Task task) {
        Optional<Task> updateTask = this.taskRepository.findById(task.getTaskId());
        Task taskUpdate = updateTask.get();
        taskUpdate.setTaskName(task.getTaskName());
        taskUpdate.setTaskAssignee(task.getTaskAssignee());
        taskUpdate.setProjectName(task.getProjectName());
        taskUpdate.setTaskStartTime(task.getTaskStartTime());
        taskUpdate.setManikantaBobbiliProperty(generatePropertyValue());
        taskRepository.save(taskUpdate);
        return taskUpdate;

    }

    @Override
    public Optional<Task> GetTaskByTaskId(String taskId) {
        return this.taskRepository.findByTaskId(taskId);
    }

    @Override
    public Optional<Task> GetTaskByTaskName(String taskName) {
        return this.taskRepository.findByTaskName(taskName);
    }

    @Override
    public List<Task> GetAllTask() {
        return this.taskRepository.findAll();
    }

    @Override
    public List<Task> getTop10ByTaskAssignee(String taskAssignee) {
        return this.taskRepository.findByTaskAssignee(taskAssignee);
    }

    @Override
    public void DeleteTaskByTaskId(String taskId) {
        this.taskRepository.deleteById(taskId);
    }
}