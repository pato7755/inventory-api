package com.afrifanom.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping(path = "/users")
public class AddUser {

    @Autowired
    UserRepository userRepository;

    @PostMapping(path = "/add", produces = "application/json", consumes = "application/json")
    public ResponseClass addUser(@RequestBody User user) {

        System.out.println("addUser: " + user.toString());

        ResponseClass response;

        try {

            userRepository.save(user);

            response = new ResponseClass("100", "User sign up successful");

            System.out.println("response: " + response.toString());

            return response;

        } catch (Exception ex) {

            ex.printStackTrace();
            System.out.println("Add user exception: " + ex.getMessage());

            response = new ResponseClass("101", "User sign up unsuccessful");

            System.out.println("response: " + response.toString());

            return response;

        }

    }

}
