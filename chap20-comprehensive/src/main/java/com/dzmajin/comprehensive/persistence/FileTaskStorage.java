package com.dzmajin.comprehensive.persistence;

import com.dzmajin.comprehensive.domain.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileTaskStorage implements TaskStorage {
    private static final String FILE_PATH = "src/main/java/com/dzmajin/comprehensive/db/taskDB.dat";

    @Override
    public void saveTasks(List<Task> tasks) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(tasks);
        } catch (IOException e) {
            throw new RuntimeException("파일 저장 중 오류 발생", e);
        }
    }

    @Override
    public List<Task> loadTasks() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Task>) ois.readObject();
        } catch (EOFException e) {
            System.out.println("회원 정보를 모두 로딩하였습니다.");
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("파일 로딩 중 오류 발생", e);
        }
    }
}
