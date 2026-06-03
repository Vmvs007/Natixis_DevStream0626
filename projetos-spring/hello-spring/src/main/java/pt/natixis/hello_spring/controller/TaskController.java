package pt.natixis.hello_spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.natixis.hello_spring.model.Task;
import pt.natixis.hello_spring.service.TaskService;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/tasks/todo")
    public List<Task> getTodoTasks() {
        return taskService.getTodoTasks();
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task created = taskService.createTask(task);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
        Task updated = taskService.updateTask(id, task);

        if(updated==null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        boolean deleted = taskService.deleteTask(id);

        if(!deleted){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
