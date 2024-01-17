package com.KiburrTask.TaskIndentify.Controller;


import com.KiburrTask.TaskIndentify.Repository.TaskService;
import com.KiburrTask.TaskIndentify.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;


    @GetMapping("/")
    public ResponseEntity < List < Task >> GetAllTask() {
        return ResponseEntity.ok().body(taskService.GetAllTask());
    }

    @GetMapping("/id={taskId}")
    public ResponseEntity<Optional<Task>> GetTaskById(@PathVariable String taskId){
        return ResponseEntity.ok().body(taskService.GetTaskByTaskId(taskId));
    }


    @GetMapping("/name={name}/")
    public ResponseEntity<Optional<Task>> GetTaskByTaskName(@PathVariable String name){
        return ResponseEntity.ok().body(taskService.GetTaskByTaskName(name));
    }

    @GetMapping("/assignee={assignee}/")
    public ResponseEntity<List<Task>> getTop10ByStartTime(@PathVariable String assignee){
        List<Task> Top10List = taskService.getTop10ByStartTime(assignee);
        return ResponseEntity.ok().body(Top10List.size()>10?Top10List.subList(0,10):Top10List);
    }


    @PostMapping("/create/")
    public ResponseEntity<Task > CreateTask(@RequestBody Task task){
        return ResponseEntity.ok().body(taskService.CreateTask(task));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity < Task> UpdateTask(@PathVariable String id, @RequestBody Task task) {
        task.setTaskId(id);
        return ResponseEntity.ok().body(this.taskService.UpdateTask(task));
    }



    @DeleteMapping("/delete/{id}")
    public String DeleteTaskById(@PathVariable String id) {
        this.taskService.DeleteTaskById(id);
        return "Deleted";

    }



}

