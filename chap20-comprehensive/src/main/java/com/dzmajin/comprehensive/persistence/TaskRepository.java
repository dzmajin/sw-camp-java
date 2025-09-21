package com.dzmajin.comprehensive.persistence;

import com.dzmajin.comprehensive.domain.Task;

import java.util.*;

public class TaskRepository {

    private final TaskStorage taskStorage;
    private final List<Task> tasks;

    public TaskRepository(TaskStorage taskStorage) {
        if (taskStorage == null) throw new NullPointerException("taskStorage");
        this.taskStorage = taskStorage;
        this.tasks = new ArrayList<>(taskStorage.loadTasks());
    }

    /* 조회 */
    public List<Task> findAll() {

        return new ArrayList<>(tasks);
    }

    public Optional<Task> findById(String id) {
        if (id == null || id.isBlank()) return Optional.empty();
        return tasks.stream().filter(t -> id.equals(t.getId())).findFirst();
    }

    /* 새로운 작업 추가 */
    public Task add(Task draft) {
        if (draft == null) throw new NullPointerException("task");
        String id = (draft.getId() == null || draft.getId().isBlank())
                ? generateId()               // ID 자동 발급
                : draft.getId();

        if (exists(id)) throw new IllegalArgumentException("중복 ID: " + id);

        Task toSave = new Task(
                id,
                draft.getTitle(),
                draft.getDueDate(),
                draft.getPriority(),
                draft.getStatus()
        );
        validate(toSave);
        tasks.add(toSave);
        taskStorage.saveTasks(tasks);
        return toSave;
    }

    /* 수정 */
    public Optional<Task> update(Task updated) {
        Objects.requireNonNull(updated, "task");
        if (updated.getId() == null || updated.getId().isBlank()) {
            throw new IllegalArgumentException("업데이트에는 ID가 필요합니다.");
        }
        validate(updated);

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(updated.getId())) {
                tasks.set(i, updated);
                taskStorage.saveTasks(tasks);
                return Optional.of(updated);
            }
        }
        return Optional.empty();
    }

    /* 삭제 */
    public boolean remove(String id) {
        boolean removed = tasks.removeIf(t -> t.getId().equals(id));
        if (removed) taskStorage.saveTasks(tasks);
        return removed;
    }

    /* 검증 */
    private boolean exists(String id) {
        return tasks.stream().anyMatch(t -> t.getId().equals(id));
    }

    private void validate(Task t) {
        if (t.getTitle() == null || t.getTitle().isBlank()) {
            throw new IllegalArgumentException("제목은 필수입니다.");
        }
    }

    private String generateId() {
        return UUID.randomUUID().toString(); // id 랜덤 생성
    }
}

