package com.example.iouring_demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.iouring_demo.User;
import com.example.iouring_demo.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginUser(HttpServletResponse response, @RequestParam String name, @RequestParam String password) throws IOException {

        List<User> users = userService.loginUser(name, password);

        if (!users.isEmpty()) {
            User user = users.get(0);
            if (user.getUsername() != null && user.getPassword() != null) {
                Cookie loginCookie = new Cookie(user.getUsername(), user.getPassword());
                loginCookie.setMaxAge(30 * 5);
                response.addCookie(loginCookie);
                return "Cookie Set: " + loginCookie;
            }
            return "Not able to set Cookie";
        }
        else
            return "User or Password incorrect";
    }
}
