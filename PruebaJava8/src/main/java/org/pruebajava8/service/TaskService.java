package org.pruebajava8.service;

import org.pruebajava8.model.Task;

import java.util.List;

public interface TaskService {
    public List<Task> getAllTasks();

    public Task saveTask(Task task);

    public Task getTaskById(Long id);

    public Task updateTask(Task task);

    public void deleteTask(Long id);
   Task getTasks(long id);

}
