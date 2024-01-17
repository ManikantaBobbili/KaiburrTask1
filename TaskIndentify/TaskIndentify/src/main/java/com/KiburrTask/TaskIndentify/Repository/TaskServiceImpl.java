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
        Optional<Task> updateTask = taskRepository.findById(task.getTaskId());
        if(updateTask.isPresent()) {
            Task taskUpdate = updateTask.get();
            taskUpdate.setTaskName(task.getTaskName());
            taskUpdate.setTaskAssignee(task.getTaskAssignee());
            taskUpdate.setProjectName(task.getProjectName());
            taskUpdate.setTaskStartTime(task.getTaskStartTime());
            taskUpdate.setManikantaBobbiliProperty(generatePropertyValue());
            return taskRepository.save(taskUpdate);
        }else {
            throw new NotFoundException("Record not found with id : " + task.getTaskId());
        }


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
    public List<Task> getTop10ByStartTime(String taskAssignee){
        return this.taskRepository.findTasksByTaskAssigneeOrderByTaskStartTime(taskAssignee);
    }

    @Override
    public void DeleteTaskById(String taskId) {
        taskRepository.deleteById(taskId);
    }
}