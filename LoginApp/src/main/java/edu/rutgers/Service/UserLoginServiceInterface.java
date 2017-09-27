package edu.rutgers.Service;

import edu.rutgers.Entity.*;



public interface UserLoginServiceInterface {

    UserDetails findOne(String username, String password);
    UserDetails create(UserLogin userLogin);
    UserLogin update(UserLogin userLogin);
    void delete(String username,String password);
    boolean findUserName(String userName);
}
