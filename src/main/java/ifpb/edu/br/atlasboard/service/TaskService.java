package ifpb.edu.br.atlasboard.service;

import org.springframework.stereotype.Service;

import ifpb.edu.br.atlasboard.domain.Task;
import ifpb.edu.br.atlasboard.exceptions.ExistingTaskException;
import ifpb.edu.br.atlasboard.exceptions.TaskNotFoundException;

@Service
public interface TaskService {
    
    public Task createTask (Task t) throws ExistingTaskException;

    public Task findById (Long id) throws TaskNotFoundException;

}
