package ifpb.edu.br.atlasboard.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ifpb.edu.br.atlasboard.domain.Task;
import ifpb.edu.br.atlasboard.domain.User;

public interface TaskRepository extends JpaRepository<Task, Long>{
    
    public Optional<List<Task>> findByUser (User user);

    @Query(nativeQuery = true,
    value = "SELECT * FROM tasks t JOIN users u ON u.id = t.user_id WHERE u.name = :name")
    public Optional<List<Task>> findByUserName (String name);

    public Optional<Task> findByName (String name);
}
