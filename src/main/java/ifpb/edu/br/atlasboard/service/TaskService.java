package ifpb.edu.br.atlasboard.service;

import org.springframework.stereotype.Service;

import ifpb.edu.br.atlasboard.domain.Task;

@Service
public interface TaskService {
    
    public Task createTask ();
}
