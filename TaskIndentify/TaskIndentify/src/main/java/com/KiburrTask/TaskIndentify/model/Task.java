package com.KiburrTask.TaskIndentify.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;
@Document(collection = "TasksCollection")
public class Task {



    private String taskName;
    private String taskId;

    private String taskAssignee;
    private String projectName;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSSX")
    private Date taskStartTime;
    private String manikantaBobbiliProperty;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskAssignee() {
        return taskAssignee;
    }

    public void setTaskAssignee(String taskAssignee) {
        this.taskAssignee = taskAssignee;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime(Date taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public String getManikantaBobbiliProperty() {
        return manikantaBobbiliProperty;
    }

    public void setManikantaBobbiliProperty(String manikantaBobbiliProperty) {
        this.manikantaBobbiliProperty = manikantaBobbiliProperty;
    }

    public Task(String taskName, String taskId, String taskAssignee, String projectName, Date taskStartTime, String manikantaBobbiliProperty) {
        this.taskName = taskName;
        this.taskId = taskId;
        this.taskAssignee = taskAssignee;
        this.projectName = projectName;
        this.taskStartTime = taskStartTime;
        this.manikantaBobbiliProperty = manikantaBobbiliProperty;
    }

    public Task() {
    }
}
