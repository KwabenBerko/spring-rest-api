package tasky.controllers;

import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tasky.dtos.CreateTaskDTO;
import tasky.dtos.UpdateTaskDTO;
import tasky.models.Task;
import tasky.repositories.TaskRepository;

import java.util.List;
import java.util.UUID;

@RestController()
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<Task> getAllTasks(){
        return taskRepository.getAllTasks();
    }

    @GetMapping("/tasks/{taskId}")
    public Task getTask(@PathVariable("taskId") String taskId){
        return taskRepository.getById(UUID.fromString(taskId));
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody CreateTaskDTO createTaskDTO){
        Task task = taskRepository.create(createTaskDTO);
        return task;
    }

    @PatchMapping("/tasks/{taskId}")
    public Task updateTask(@PathVariable("taskId") String taskId, @RequestBody UpdateTaskDTO updateTaskDTO){
        return taskRepository.update(UUID.fromString(taskId), updateTaskDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/tasks/{taskId}")
    public void deleteTask(@PathVariable("taskId") String taskId){
        taskRepository.delete(UUID.fromString(taskId));
    }

}
