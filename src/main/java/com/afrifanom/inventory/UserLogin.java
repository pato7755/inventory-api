package com.afrifanom.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserLogin {

    @Autowired
    UserRepository userRepository;

    @PostMapping(path = "/login", produces = "application/json", consumes = "application/json")
    public ResponseClass userLogin(@RequestBody User userModel) {

        System.out.println("userModel: " + userModel.toString());

        ResponseClass response;

        try {

            User userDetails = userRepository.findByUserId(userModel.getUserId());

            if (userModel.getPassword().equals(userDetails.getPassword())) {

                response = new ResponseClass("100", "Login successful");

            } else {

                response = new ResponseClass("101", "Wrong password");

            }

            System.out.println("response: " + response.toString());

            return response;

        } catch (Exception ex) {

            ex.printStackTrace();
            System.out.println("Add user exception: " + ex.getMessage());

            response = new ResponseClass("102", "User not found");

            System.out.println("response: " + response.toString());

            return response;

        }

    }

}
