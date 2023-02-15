package ifpb.edu.br.atlasboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ifpb.edu.br.atlasboard.domain.Task;
import ifpb.edu.br.atlasboard.domain.TaskPriority;
import ifpb.edu.br.atlasboard.exceptions.ExistingTaskException;
import ifpb.edu.br.atlasboard.exceptions.TaskNotFoundException;
import ifpb.edu.br.atlasboard.exceptions.UserNotFoundException;

@Service
public interface TaskService {
    
    public Task createTask (Task task) throws ExistingTaskException;

    public Task findById (Long id) throws TaskNotFoundException;

    public List<Task> findByUserName (String name) throws UserNotFoundException;

    public Task findByTaskName (String name) throws TaskNotFoundException;

    public Task updateTask (Long id, Task task) throws ExistingTaskException, TaskNotFoundException;

    public Task updatePriority (Long id, TaskPriority priority) throws TaskNotFoundException;

    public void deleteTask (Long id) throws TaskNotFoundException;

}
