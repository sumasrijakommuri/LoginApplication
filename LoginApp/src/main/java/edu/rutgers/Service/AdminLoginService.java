package edu.rutgers.Service;

import edu.rutgers.Entity.*;
import edu.rutgers.Exception.*;
import edu.rutgers.Repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
@Transactional
public class AdminLoginService implements AdminLoginServiceInterface{

    @Autowired
    AdminLoginRepository repository;

    public List<UserLogin> findall() {
        return repository.findall();
    }

    public UserDetails findOne(String username, String password) {
        UserDetails response = repository.findOne(username,password);
                if(response ==null)
                {
                    throw new UserNotFoundException("Username or Password not correct.");
                }
        return response;
    }

    public UserDetails create(UserLogin userLogin) {
        boolean exists = repository.findUserName(userLogin.getUserid());
        if(exists)
        {
            throw new UserAlreadyExistsException("The UserName is already taken.");
        }
        return repository.create(userLogin);
    }

    public UserLogin update(UserLogin userLogin) {
        return repository.update(userLogin);
    }

    public void delete(String username, String password) {
        boolean exists = repository.findUserName(username);
        if(!exists)
        {
            throw new UserNotFoundException("User does not exist.");
        }
        repository.delete(username,password);
    }

    public boolean findUserName(String username) {
        return repository.findUserName(username);
    }

}
