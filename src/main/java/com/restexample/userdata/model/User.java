package com.restexample.userdata.model;


import javax.validation.constraints.NotBlank;


public class User {
    private long id;
    @NotBlank(message = "Name is mandatory")
    private String userName;
    private String profession;
    private String description;

    public User() {

    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getProfession() {
        return profession;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + userName + '\'' +
                ", profession='" + profession + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public User(long id, String userName, String profession, String description) {
        this.id = id;
        this.userName = userName;
        this.profession = profession;
        this.description = description;
    }
}
