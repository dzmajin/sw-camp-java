package com.dzmajin.comprehensive.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Task implements Serializable {
    private String id;
    private String title;
    private LocalDateTime dueDate;
    private Priority priority;
    private Status status;

    public Task(String id,  String title, LocalDateTime dueDate, Priority priority, Status status){
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
    }
    public Task Updated(String title, LocalDateTime dueDate, Priority priority, Status status) {
        return new Task(this.id, title, dueDate, priority, status);
    }
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public LocalDateTime getDueDate() {
        return dueDate;
    }
    public Priority getPriority() {
        return priority;
    }
    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", Priority=" +  priority +
                ", status=" + status +
                '}';
    }

}