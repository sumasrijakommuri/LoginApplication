package edu.rutgers.Entity;

import javax.persistence.*;


@Entity
@NamedQueries(
        @NamedQuery(name = "Users.findAll", query ="select userlogin from UserLogin userlogin")
)
public class UserLogin {

    @Id
    private String userid;

    private String email;
    private String password;

    @Embedded
    private UserDetails details;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetails getDetails() {
        return details;
    }

    public void setDetails(UserDetails details) {
        this.details = details;
    }
}