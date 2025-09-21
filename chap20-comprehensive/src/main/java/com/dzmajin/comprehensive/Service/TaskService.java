package com.dzmajin.comprehensive.Service;

import com.dzmajin.comprehensive.domain.Priority;
import com.dzmajin.comprehensive.domain.Status;
import com.dzmajin.comprehensive.domain.Task;
import com.dzmajin.comprehensive.persistence.TaskRepository;

import java.time.LocalDateTime;
import java.util.*;

public class TaskService {

    private final TaskRepository taskrepository;

    public TaskService(TaskRepository taskrepository) {
        this.taskrepository = taskrepository;
    }

    /* 새 작업 추가: 제목 필수, 기본 상태 NOT_STARTED, 기본 우선순위 P2_MEDIUM */
    public Task add(String title) {
        if (title == null || title.trim().isBlank()) {
            throw new IllegalArgumentException("제목은 필수입니다.");
        }
        // 기본값
        Priority defaultPriority = Priority.P2_MEDIUM;  // 우선순위 - 보통
        Status defaultStatus = Status.NOT_STARTE;       // 상태 - 시작 전

        Task draft = new Task(
                null,                   // ID는 Repository가 자동 발급
                title.trim(),
                null,                   // 기본값 : 마감일 없음
                defaultPriority,
                defaultStatus
        );
        return taskrepository.add(draft);
    }

    /* 전체 조회 */
    public List<Task> list() {
        return taskrepository.findAll();
    }


    /* 수정 */
    public boolean update(String id, String title, LocalDateTime due, Priority priority, Status status) {
        if (id == null || id.isBlank()) return false;
        var opt = taskrepository.findById(id);
        if (opt.isEmpty()) return false;

        Task old = opt.get();
        Task updated = new Task(
                old.getId(),
                (title != null && !title.trim().isBlank()) ? title.trim() : old.getTitle(),
                (due != null) ? due : old.getDueDate(),
                (priority != null) ? priority : old.getPriority(),
                (status != null) ? status : old.getStatus()
        );
        return taskrepository.update(updated).isPresent();
    }

    /* 완료 처리 */
    public boolean complete(String id) {
        if (id == null || id.isBlank()) return false;

        var opt = taskrepository.findById(id);
        if (opt.isEmpty()) return false;

        Task t = opt.get();
        Task updated = new Task(t.getId(), t.getTitle(), t.getDueDate(), t.getPriority(), Status.COMPLETED);
        return taskrepository.update(updated).isPresent();
    }

    /* 삭제 */
    public boolean delete(String id) {
        if (id == null || id.isBlank()) return false;
        return taskrepository.remove(id);
    }
}