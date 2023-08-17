package com.Solution.in.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "micro_user")
public class User {

    @Id
    @Column(name = "UserId")
    private String userId;

    @Column(name = "Name")
    private String name;

    @Column(name = "About")
    private String about;

    @Column(name = "Email")
    private String email;

    @javax.persistence.Transient
    private List<Rating> ratings = new ArrayList<>(); // List to store ratings

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public User() {
        super();
    }

    public User(String userId, String name, String about, String email) {
        super();
        this.userId = userId;
        this.name = name;
        this.about = about;
        this.email = email;
    }
}
