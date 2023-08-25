package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.examly.springapp.service.TasksService;
import com.examly.springapp.model.Task;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TaskController {

	@Autowired
	TasksService tasksservice;

    @GetMapping("/alltasks")
	public List<Task> getAllTasks()
	{
		return tasksservice.getAllTasks();
	}

    @GetMapping("/getTask")
	public Task getTask(@RequestParam("taskId") String taskId)
	{
		return tasksservice.getTaskById(taskId);
	}

    @DeleteMapping("/deleteTask")
	public void deleteTask(@RequestParam("taskid") String taskid)
	{
		tasksservice.delete(taskid);
	}

	@PostMapping("/saveTask")
	public String saveTask(@RequestBody Task task) 
	{
		tasksservice.saveTasks(task);
        return task.getTaskId();
	}

	@PutMapping("/changeStatus")
	public Task updateTaskStatus(@RequestBody Task task)
	{
		tasksservice.updateTaskStatus(task);
		return task;
	}    



}