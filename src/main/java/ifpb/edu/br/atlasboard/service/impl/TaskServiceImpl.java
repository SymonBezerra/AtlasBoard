package ifpb.edu.br.atlasboard.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpb.edu.br.atlasboard.domain.Task;
import ifpb.edu.br.atlasboard.domain.TaskPriority;
import ifpb.edu.br.atlasboard.domain.User;
import ifpb.edu.br.atlasboard.exceptions.ExistingTaskException;
import ifpb.edu.br.atlasboard.exceptions.TaskNotFoundException;
import ifpb.edu.br.atlasboard.exceptions.UserNotFoundException;
import ifpb.edu.br.atlasboard.repository.TaskRepository;
import ifpb.edu.br.atlasboard.repository.UserRepository;
import ifpb.edu.br.atlasboard.service.TaskService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    private final UserRepository userRepository;

    // POST
    @Override
    public Task createTask(Task task) throws ExistingTaskException {
        if (taskRepository.findByName(task.getName()).isPresent()) {
            throw new ExistingTaskException("Esta atividade já está cadastrada na plataforma!");
        }
        return taskRepository.save(task);
    }

    // GET
    @Override
    public Task findById(Long id) throws TaskNotFoundException {
        Optional<Task> t = taskRepository.findById(id);
        if (!t.isPresent()) {
            throw new TaskNotFoundException("Esta atividade não está cadastrada na plataforma!");
        }
        return t.get();
    }

    //GET
    @Override
    public List<Task> findByUserName(String name) throws UserNotFoundException {
        Optional<User> user = userRepository.findByName(name);
        if (!user.isPresent()) {
            throw new UserNotFoundException("Este usuário não está cadastrado no AtlasBoard!");
        }

        return taskRepository.findByUserName(user.get().getName()).get();
    }

    // GET
    @Override
    public Task findByTaskName(String name) throws TaskNotFoundException {
        Optional<Task> task = taskRepository.findByName(name);
        if (!task.isPresent()) {
            throw new TaskNotFoundException ("Esta tarefa não está cadastrada!");
        }

        return task.get();
    }
    
    // PUT
    @Override
    public Task updateTask(Long id, Task task) throws ExistingTaskException, TaskNotFoundException {
        if (!taskRepository.findById(id).isPresent()) {
            throw new TaskNotFoundException("Esta tarefa não está cadastrada!");
        } else if (taskRepository.findByName(task.getName()).isPresent()) {
            throw new ExistingTaskException ("Já existe uma tarefa cadastrada com este nome!");
        }
        task.setId(id);
        return taskRepository.save(task);
    }

    // PATCH
    @Override
    public Task updatePriority(Long id, TaskPriority priority) throws TaskNotFoundException {
        Optional<Task> taskToUpdate = taskRepository.findById(id);
        if (!taskToUpdate.isPresent()) {
            throw new TaskNotFoundException("Esta tarefa não está cadastrada!");
        } 
        taskToUpdate.get().setPriority(priority);
        return taskRepository.save(taskToUpdate.get());
    }

    // DELETE
    @Override
    public void deleteTask(Long id) throws TaskNotFoundException {
        Optional<Task> taskToDelete = taskRepository.findById(id);
        if (!taskToDelete.isPresent()) {
            throw new TaskNotFoundException("Esta tarefa não está cadastrada!");
        }
        taskRepository.delete(taskToDelete.get());
    }
    
}
