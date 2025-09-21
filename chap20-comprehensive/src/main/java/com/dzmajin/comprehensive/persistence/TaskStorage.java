package com.dzmajin.comprehensive.persistence;

import com.dzmajin.comprehensive.domain.Task;

import java.util.List;

public interface TaskStorage {
    void saveTasks(List<Task> tasks);
    List<Task> loadTasks();
}
