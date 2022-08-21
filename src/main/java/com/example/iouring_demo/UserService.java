package com.example.iouring_demo;


import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iouring_demo.User;
import com.example.iouring_demo.UserRepository;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers()
    {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
    public List<User> loginUser(String username,String password) {
        List<User> users=userRepository.findByUsernameAndPassword(username,password);
        return users;
    }
}

