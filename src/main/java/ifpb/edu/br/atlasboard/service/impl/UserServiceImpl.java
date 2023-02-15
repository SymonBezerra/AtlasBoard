package ifpb.edu.br.atlasboard.service.impl;

import java.util.List;

import ifpb.edu.br.atlasboard.domain.Task;
import ifpb.edu.br.atlasboard.domain.User;
import ifpb.edu.br.atlasboard.exceptions.TaskNotFoundException;
import ifpb.edu.br.atlasboard.exceptions.UserNotFoundException;
import ifpb.edu.br.atlasboard.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public List<User> listAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findById(Long id) throws UserNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findByTask(Task task) throws TaskNotFoundException, UserNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User updateUser(Long id, User user) throws UserNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteUser(Long id) throws UserNotFoundException {
        // TODO Auto-generated method stub
        
    }
    
}
