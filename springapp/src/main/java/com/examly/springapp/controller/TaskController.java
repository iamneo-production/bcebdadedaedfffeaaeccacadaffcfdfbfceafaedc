package com.examly.springapp.controller;

import com.examly.springapp.entity.Taskentity;
import com.examly.springapp.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks") // Specify the base path
public class TaskController {
    @Autowired
    private TaskService service;
    
    @PostMapping("/saveTask")
    public Taskentity saveTask(@RequestBody Taskentity taskEntity) {
        Taskentity output = service.saveTask(taskEntity);
        return output;
    }

    @GetMapping("/changeStatus")
    public Taskentity updateTaskStatus(@RequestParam("id") String id) {
        return service.updateTaskStatus(id);
    }

    @GetMapping("/deleteTask")
    public String deleteTask(@RequestParam("id") String id) {
        return service.deleteTask(id);
    }

    @GetMapping("/alltasks")
    public List<Taskentity> getAllTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/getTask")
    public Taskentity getTask(@RequestParam("id") String id) {
        return service.getTaskById(id);
    }
}
