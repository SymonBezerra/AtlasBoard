package ifpb.edu.br.atlasboard.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ifpb.edu.br.atlasboard.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    public Optional<User> findByName (String name);
}
