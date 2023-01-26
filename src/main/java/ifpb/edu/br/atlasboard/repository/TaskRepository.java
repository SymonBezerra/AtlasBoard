package ifpb.edu.br.atlasboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ifpb.edu.br.atlasboard.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
    
    // @Query("SELECT t FROM Task t JOIN t.user_id u WHERE u = :id")
    // public List<Task> findByUserID (Long id);

    // public List<Task>
}
