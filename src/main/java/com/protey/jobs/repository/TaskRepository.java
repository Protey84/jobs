package com.protey.jobs.repository;

import com.protey.jobs.entity.Task;

import java.util.Date;
import java.util.List;

public interface TaskRepository {
    // null if not found, when updated
    Task save(Task task);

    // false if not found
    boolean delete(int id);

    // null if not found
    Task get(int id);

    // null if not found
    List<Task> getByDate(Date date);

    List<Task> getAll();
}
