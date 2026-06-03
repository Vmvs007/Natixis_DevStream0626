package pt.natixis.hello_spring.service;

import org.springframework.stereotype.Service;
import pt.natixis.hello_spring.model.Task;
import pt.natixis.hello_spring.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id);
    }
    
    public List<Task> getTodoTasks() {

        List<Task> tasks = taskRepository.findAll();

        List<Task> todoTasks = new ArrayList<>();


        for (Task taskAtual : tasks) {
            if (!taskAtual.isDone()) {
                todoTasks.add(taskAtual);
            }
        }

        return todoTasks;
    }

    public Task createTask(Task task){
        task.setId(0L);
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask){
        Task existing = taskRepository.findById(id);

        if(existing==null){
            return null;
        }

        updatedTask.setId(id);
        return taskRepository.save(updatedTask);
    }

    public boolean deleteTask(Long id){
        Task existing = taskRepository.findById(id);

        if(existing==null){
            return false;
        }

        taskRepository.deleteById(id);
        return true;

    }
}
