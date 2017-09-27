package edu.rutgers.Entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class UserDetails {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String detailsid;

    //personal details
    private String first_name;
    private String last_name;
    private String country;
    private String field;

    //schooling details
    private String school_name;
    private String year_completed;

    //work details
    private String company_name;
    private String position;
    private String working_since_year;


    public UserDetails(){
        detailsid = UUID.randomUUID().toString();
    }
    //getters and setters

    public String getDetailsid() {
        return detailsid;
    }

    public void setDetailsid(String detailsid) {
        this.detailsid = detailsid;
    }
    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getYear_completed() {
        return year_completed;
    }

    public void setYear_completed(String year_completed) {
        this.year_completed = year_completed;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorking_since_year() {
        return working_since_year;
    }

    public void setWorking_since_year(String working_since_year) {
        this.working_since_year = working_since_year;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
