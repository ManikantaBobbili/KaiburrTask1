package com.KiburrTask.TaskIndentify.Repository;

import com.KiburrTask.TaskIndentify.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TaskRepository extends MongoRepository<Task,String> {

    Optional<Task> findByTaskId(String taskId);
    Optional<Task> findByTaskName(String taskName);

    List<Task> findTasksByTaskAssigneeOrderByTaskStartTime(String taskAssignee);

}
