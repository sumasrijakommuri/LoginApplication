package edu.rutgers.Service;

import edu.rutgers.Entity.*;

import java.util.*;


public interface AdminLoginServiceInterface {

    List<UserLogin> findall();
    UserDetails findOne(String username, String password);
    UserDetails create(UserLogin userLogin);
    UserLogin update(UserLogin userLogin);
    void delete(String username,String password);
    boolean findUserName(String username);
}
