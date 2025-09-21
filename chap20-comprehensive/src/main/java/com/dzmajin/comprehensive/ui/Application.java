package com.dzmajin.comprehensive.ui;

import com.dzmajin.comprehensive.Service.TaskService;
import com.dzmajin.comprehensive.domain.Priority;
import com.dzmajin.comprehensive.domain.Status;
import com.dzmajin.comprehensive.domain.Task;
import com.dzmajin.comprehensive.persistence.FileTaskStorage;
import com.dzmajin.comprehensive.persistence.TaskRepository;
import com.dzmajin.comprehensive.persistence.TaskStorage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Application {

    private final TaskService taskService;
    private final Scanner scanner;

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Application() {
        TaskStorage taskStorage = new FileTaskStorage();
        TaskRepository taskRepository = new TaskRepository(taskStorage);
        this.taskService = new TaskService(taskRepository);
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        new Application().run();
    }

    public void run() {
        while (true) {
            System.out.println("\n===== TODO 프로그램 =====");
            System.out.println("1. 모든 작업 조회");
            System.out.println("2. 작업 추가");
            System.out.println("3. 작업 수정");
            System.out.println("4. 완료 처리");
            System.out.println("5. 작업 삭제");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴 선택: ");

            int choice = readInt();
            try {
                switch (choice) {
                    case 1 -> showAll();
                    case 2 -> addTask();
                    case 3 -> modifyTask();
                    case 4 -> completeTask();
                    case 5 -> removeTask();
                    case 9 -> {
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }
                    default -> System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("[입력 오류] " + e.getMessage());
            } catch (Exception e) {
                System.out.println("[오류] " + e.getClass().getSimpleName() + ": " + e.getMessage());
            }
        }
    }

    /* 메뉴 */

    private void showAll() {
        List<Task> list = taskService.list();
        if (list.isEmpty()) {
            System.out.println("(비어 있음)");
            return;
        }
        System.out.println("\n-- 작업 목록 --");
        for (int i = 0; i < list.size(); i++) {
            Task t = list.get(i);
            System.out.printf("%d) %s | 상태:%s | 우선:%s | 마감:%s | id=%s%n",
                    i + 1,
                    t.getTitle(),
                    label(t.getStatus()),
                    label(t.getPriority()),
                    t.getDueDate() == null ? "-" : t.getDueDate().format(DTF),
                    t.getId());
        }
    }

    private void addTask() {
        System.out.print("제목: ");
        String title = scanner.nextLine();
        Task created = taskService.add(title); // 기본값: NOT_STARTE(시작 전), P2_MEDIUM(보통)

        // 옵션(엔터로 건너뛰기)
        LocalDateTime due = askDue("마감(yyyy-MM-dd HH:mm, 엔터=없음): ");
        Priority pr = askPriority("우선순위(1=HIGH, 2=MEDIUM, 3=LOW, 엔터=기본 유지): ");
        Status st = askStatus("상태(0=NOT_STARTE, 1=IN_PROGRESS, 2=COMPLETED, 엔터=기본 유지): ");

        if (due != null || pr != null || st != null) {
            boolean ok = taskService.update(created.getId(), null, due, pr, st);
            System.out.println(ok ? "추가 정보 반영 완료" : "추가 정보 반영 실패");
        } else {
            System.out.println("작업이 추가되었습니다.");
        }
    }

    private void modifyTask() {
        List<Task> view = taskService.list();
        if (view.isEmpty()) { System.out.println("(수정할 항목이 없습니다)"); return; }
        showAll();

        System.out.print("수정할 번호: ");
        int idx = readIndex(view.size());
        String id = view.get(idx).getId();

        System.out.print("새 제목(엔터=유지): ");
        String titleIn = scanner.nextLine();
        String title = titleIn.isBlank() ? null : titleIn;

        LocalDateTime due = askDue("새 마감(yyyy-MM-dd HH:mm, 엔터=유지): ");
        Priority pr = askPriority("새 우선순위(1=HIGH, 2=MEDIUM, 3=LOW, 엔터=유지): ");
        Status st = askStatus("새 상태(0=NOT_STARTED, 1=IN_PROGRESS, 2=COMPLETED, 엔터=유지): ");

        boolean ok = taskService.update(id, title, due, pr, st);
        System.out.println(ok ? "수정 완료" : "수정 실패");
    }

    private void completeTask() {
        List<Task> view = taskService.list();
        if (view.isEmpty()) { System.out.println("(완료 처리할 항목이 없습니다)"); return; }
        showAll();

        System.out.print("완료 처리할 번호: ");
        int idx = readIndex(view.size());
        String id = view.get(idx).getId();

        boolean ok = taskService.complete(id);
        System.out.println(ok ? "완료 처리되었습니다." : "완료 처리 실패");
    }

    private void removeTask() {
        List<Task> view = taskService.list();
        if (view.isEmpty()) { System.out.println("(삭제할 항목이 없습니다)"); return; }
        showAll();

        System.out.print("삭제할 번호: ");
        int idx = readIndex(view.size());
        String id = view.get(idx).getId();

        boolean ok = taskService.delete(id);
        System.out.println(ok ? "삭제되었습니다." : "삭제 실패");
    }

    /* 잘못된 입력 */

    private int readInt() {
        String s = scanner.nextLine().trim();
        try { return Integer.parseInt(s); }
        catch (NumberFormatException e) { return -1; }
    }

    private int readIndex(int size) {
        int n = readInt();
        if (n < 1 || n > size) throw new IllegalArgumentException("번호 범위를 벗어났습니다.");
        return n - 1; // 0-based
    }

    private LocalDateTime askDue(String prompt) {
        System.out.print(prompt);
        String in = scanner.nextLine().trim();
        if (in.isBlank()) return null;
        try { return LocalDateTime.parse(in, DTF); }
        catch (DateTimeParseException e) {
            System.out.println("형식이 올바르지 않습니다. 마감은 변경하지 않습니다.");
            return null;
        }
    }

    private Priority askPriority(String prompt) {
        System.out.print(prompt);
        String in = scanner.nextLine().trim();
        if (in.isBlank()) return null;
        return switch (in) {
            case "1" -> Priority.P1_HIGH;
            case "2" -> Priority.P2_MEDIUM;
            case "3" -> Priority.P3_LOW;
            default -> { System.out.println("잘못된 입력. 우선순위는 변경하지 않습니다."); yield null; }
        };
    }

    private Status askStatus(String prompt) {
        System.out.print(prompt);
        String in = scanner.nextLine().trim();
        if (in.isBlank()) return null;
        return switch (in) {
            case "0" -> Status.NOT_STARTE;
            case "1" -> Status.IN_PROGRESS;
            case "2" -> Status.COMPLETED;
            default -> { System.out.println("잘못된 입력. 상태는 변경하지 않습니다."); yield null; }
        };
    }

    private String label(Object o) {
        return switch (o) {
            case null -> "-";
            case Priority p -> p.label();
            case Status s -> s.label();
            default -> String.valueOf(o);
        };
    }
}
