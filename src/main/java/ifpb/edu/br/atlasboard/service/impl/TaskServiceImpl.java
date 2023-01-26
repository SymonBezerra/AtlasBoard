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

    @Override
    public Task createTask(Task task) throws ExistingTaskException {
        if (taskRepository.findByName(task.getName()).isPresent()) {
            throw new ExistingTaskException("Esta atividade já está cadastrada na plataforma!");
        }
        return taskRepository.save(task);
    }

    @Override
    public Task findById(Long id) throws TaskNotFoundException {
        Optional<Task> t = taskRepository.findById(id);
        if (!t.isPresent()) {
            throw new TaskNotFoundException("Esta atividade não está cadastrada na plataforma!");
        }
        return t.get();
    }

    @Override
    public List<Task> findByUserName(String name) throws UserNotFoundException {
        Optional<User> user = userRepository.findByName(name);
        if (!user.isPresent()) {
            throw new UserNotFoundException("Este usuário não está cadastrado no AtlasBoard!");
        }

        return taskRepository.findByUser(user.get()).get();
    }

    @Override
    public Task findByTaskName(String name) throws TaskNotFoundException {
        Optional<Task> task = taskRepository.findByName(name);
        if (!task.isPresent()) {
            throw new TaskNotFoundException ("Esta tarefa não está cadastrada!");
        }

        return task.get();
    }

    @Override
    public Task updateTask(Long id, Task task) throws ExistingTaskException, TaskNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Task updatePriority(Long id, TaskPriority priority) throws TaskNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Task deleteTask(Long id) throws TaskNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }
    
}
