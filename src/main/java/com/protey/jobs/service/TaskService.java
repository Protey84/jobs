package com.protey.jobs.service;

import com.protey.jobs.entity.Task;
import com.protey.jobs.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

import static com.protey.jobs.util.ValidationUtil.checkNotFoundWithId;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public List<Task> getAll() {
        return repository.getAll();
    }

    public List<Task> getTasksByDate(Date date){
        return repository.getByDate(date);
    }

    public void update(Task task, int userId) {
        Assert.notNull(task, "meal must not be null");
        checkNotFoundWithId(repository.save(task), task.getId());
    }

    public Task create(Task task) {
        Assert.notNull(task, "meal must not be null");
        return repository.save(task);
    }

}
