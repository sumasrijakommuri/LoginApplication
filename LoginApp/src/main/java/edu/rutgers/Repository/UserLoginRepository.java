package edu.rutgers.Repository;

import edu.rutgers.Entity.*;
import edu.rutgers.Exception.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.persistence.*;

@Repository
public class UserLoginRepository implements UserLoginRepositoryInterface{

    @PersistenceContext
    EntityManager entityManager;

    public UserDetails findOne(String username, String password) {

        UserLogin exists = entityManager.find(UserLogin.class, username);
        if (exists.getPassword().equals(password)) {
            return exists.getDetails();
        } else
            throw new UserNotFoundException("Username or Password is incorrect.");
    }

    public UserDetails create(UserLogin userLogin) {
        entityManager.persist(userLogin);
        return userLogin.getDetails();
    }

    public UserLogin update(UserLogin userLogin) {
        boolean exists = findUserName(userLogin.getUserid());
        if (exists) {
            entityManager.merge(userLogin);
        } else {
            entityManager.persist(userLogin);
        }
        return userLogin;
    }

    public void delete(String username, String password) {
        UserLogin exists = entityManager.find(UserLogin.class, username);
        if (exists != null && exists.getPassword().equals(password)) {
            entityManager.remove(exists);
        } else {
            throw new UserNotFoundException("Username or password incorrect.");
        }

    }

    public boolean findUserName(String username) {
        UserLogin exists = entityManager.find(UserLogin.class, username);
        if (exists == null) {
            return false;
        } else {
            return true;
        }
    }
}
