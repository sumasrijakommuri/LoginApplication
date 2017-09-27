package edu.rutgers.Repository;


import edu.rutgers.Entity.*;
import edu.rutgers.Exception.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.persistence.*;
import java.util.*;

@Repository
public class AdminLoginRepository implements AdminLoginRepositoryInterface {

    @PersistenceContext
    EntityManager entityManager;

    public List<UserLogin> findall() {
        TypedQuery<UserLogin> query = entityManager.createNamedQuery("Users.findAll", UserLogin.class);
        return query.getResultList();
    }

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

    public boolean findUserName(String userName) {
        UserLogin exists = entityManager.find(UserLogin.class, userName);
        if (exists == null) {
            return false;
        } else {
            return true;
        }
    }
}
