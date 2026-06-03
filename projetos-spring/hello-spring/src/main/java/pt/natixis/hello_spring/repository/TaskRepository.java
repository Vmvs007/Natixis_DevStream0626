package pt.natixis.hello_spring.repository;

import org.springframework.stereotype.Repository;
import pt.natixis.hello_spring.model.Task;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {

    private Long nextId = 6L;
    private List<Task> tasks = new ArrayList<>();

    public TaskRepository() {
        // Popular o array com dados mock
        // Mais para a frente, a ligação à Base de Dados fica aqui

        tasks.add(new Task(1L, "Aprender Spring Boot", false));
        tasks.add(new Task(2L, "Ir apanhar sol à beira mar", false));
        tasks.add(new Task(3L, "Lavar a loiça", true));
        tasks.add(new Task(4L, "Levar o cão a passear", false));
        tasks.add(new Task(5L, "Instalar a nova versão do IntellIj", false));
    }

    public Task save(Task task) {

        // Função com dois propósitos
        // Criar nova tarefa (caso o id chegue a 0)
        // Atualizar uma tarefa (caso o id chegue diferente de 0)

        if (task.getId() == 0) {
            // Atribuimos o id correto
            task.setId(nextId);

            // Avançamos a variável nextId para +1
            nextId++;

            // Adicionamos a task à lista
            tasks.add(task);
        } else {
            Task existing = findById(task.getId());

            if (existing != null) {
                existing.setDescription(task.getDescription());
                existing.setDone(task.isDone());
            } else {
                tasks.add(task);
            }
        }
        return task;
    }

    public void deleteById(Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }

    public List<Task> findAll() {
        return tasks;
    }

    public Task findById(Long id) {
        for (Task taskAtual : tasks) {
            if (taskAtual.getId().equals(id)) {
                return taskAtual;
            }
        }

        return null;
    }
}
