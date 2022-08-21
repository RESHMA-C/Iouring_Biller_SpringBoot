package com.example.iouring_demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.zip.DeflaterOutputStream;

@Entity
@Table(name = "users")
public class User
{
    @Id
    private String username;
    private String email;
    private String password;


    public User()
    {
    }
    public String  getUsername()
    {
        return username;
    }
    public void setUsername(String userName)
    {
        this.username=username;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
}

