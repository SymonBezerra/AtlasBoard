package ifpb.edu.br.atlasboard.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ifpb.edu.br.atlasboard.domain.Task;
import ifpb.edu.br.atlasboard.domain.User;

public interface TaskRepository extends JpaRepository<Task, Long>{
    
    public Optional<List<Task>> findByUser (User user);

    public Optional<Task> findByName (String name);
}
