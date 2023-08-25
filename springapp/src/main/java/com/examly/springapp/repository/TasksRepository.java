package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TasksRepository extends CrudRepository<Task, String> {
    // Other methods...
    
    @Modifying
    @Query("UPDATE Task t SET t.taskStatus = :taskStatus WHERE t.taskId = :taskId")
    void updateTaskStatus(String taskId, String taskStatus);
}
