package edu.rutgers.Repository;

import edu.rutgers.Entity.*;

import java.util.*;

public interface AdminLoginRepositoryInterface {
    List<UserLogin> findall();
    UserDetails findOne(String username, String password);
    UserDetails create(UserLogin userLogin);
    UserLogin update(UserLogin userLogin);
    void delete(String username,String password);
    boolean findUserName(String userName);
}
