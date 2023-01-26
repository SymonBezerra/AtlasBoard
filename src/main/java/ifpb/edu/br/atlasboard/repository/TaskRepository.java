package ifpb.edu.br.atlasboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ifpb.edu.br.atlasboard.domain.Task;
import ifpb.edu.br.atlasboard.domain.User;

public interface TaskRepository extends JpaRepository<Task, Long>{
    
    public List<Task> findByUser (User user);
}
