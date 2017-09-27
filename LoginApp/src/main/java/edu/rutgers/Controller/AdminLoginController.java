package edu.rutgers.Controller;

import edu.rutgers.Entity.*;
import edu.rutgers.Service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@CrossOrigin
public class AdminLoginController {

    @Autowired
    private AdminLoginServiceInterface service;

    @RequestMapping(method = RequestMethod.GET, value = "/adminlogin",produces = APPLICATION_JSON_UTF8_VALUE)
    public List<UserLogin> findAll(){return service.findall();}

    @RequestMapping(method = RequestMethod.GET, value = "/adminlogin/{username}/{password}",produces = APPLICATION_JSON_UTF8_VALUE)
    public UserDetails login(@PathVariable("username") String userid,@PathVariable("password") String password){return service.findOne(userid,password);}

    @RequestMapping(method = RequestMethod.POST, value = "/adminlogin",produces = APPLICATION_JSON_UTF8_VALUE, consumes = APPLICATION_JSON_UTF8_VALUE)
    public UserDetails create(@RequestBody UserLogin userLogin){ return service.create(userLogin);}

    @RequestMapping(method = RequestMethod.PUT, value="/adminlogin",produces = APPLICATION_JSON_UTF8_VALUE, consumes = APPLICATION_JSON_UTF8_VALUE)
    public UserLogin update(@RequestBody UserLogin userLogin){return service.update(userLogin);}

    @RequestMapping(method = RequestMethod.DELETE, value = "/adminlogin/{username}/{password}", consumes = APPLICATION_JSON_UTF8_VALUE)
    public void delete(@PathVariable("username") String userid,@PathVariable("password") String password){service.delete(userid,password);}
}
