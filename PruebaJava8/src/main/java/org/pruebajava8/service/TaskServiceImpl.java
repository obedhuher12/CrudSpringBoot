package org.pruebajava8.service;

import org.pruebajava8.model.Task;
import org.pruebajava8.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Override
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public Task saveTask(Task task) {
        return repository.save(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Task updateTask(Task task) {
        return repository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Task getTasks(long id) {
        Optional<Task> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

}
