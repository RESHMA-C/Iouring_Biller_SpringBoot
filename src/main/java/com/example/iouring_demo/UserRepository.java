package com.example.iouring_demo;

import com.example.iouring_demo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Repository
public interface UserRepository extends CrudRepository<User, Long>
{
    List<User> findByUsernameAndPassword(String username,String password);
}

