package ifpb.edu.br.atlasboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ifpb.edu.br.atlasboard.domain.Task;
import ifpb.edu.br.atlasboard.domain.User;
import ifpb.edu.br.atlasboard.exceptions.TaskNotFoundException;
import ifpb.edu.br.atlasboard.exceptions.UserNotFoundException;

@Service
public interface UserService {
    
    public List<User> listAll ();
    
    public User findById (Long id) throws UserNotFoundException;

    public User findByTask (Task task) throws TaskNotFoundException, UserNotFoundException;

    public User updateUser (Long id, User user) throws UserNotFoundException;

    public void deleteUser (Long id) throws UserNotFoundException;
}
