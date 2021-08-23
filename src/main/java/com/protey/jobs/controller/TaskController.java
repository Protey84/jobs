package com.protey.jobs.controller;

import com.protey.jobs.entity.Task;
import com.protey.jobs.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/tasks")
    public String orders(Model model) {
        model.addAttribute("tasks", service.getAll());
        return "tasks";
    }

    @GetMapping("tasks/{id}")
    public String showTask(@PathVariable("id") int id, Model model) {
        Task task=service.get(id);
        model.addAttribute("task", task);
        return "task";
    }
}
