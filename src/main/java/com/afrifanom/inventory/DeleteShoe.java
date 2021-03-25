package com.afrifanom.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "/shoes")
public class DeleteShoe {

    @Autowired
    ShoeRepository shoeRepository;

    @Autowired
    UserRepository userRepository;

    @DeleteMapping(path = "/delete", produces = "application/json", consumes = "application/json")
    public ResponseClass deleteShoe(@RequestParam String shoeId, @RequestParam String id) {

        ResponseClass response;

        System.out.println(id);
        System.out.println(shoeId);

        try {

            if (id != null && !id.isEmpty()) {

                User userDetails = userRepository.findByUserId(id);

                System.out.println("userDetails: " + userDetails.toString());

                if (userDetails.getRole().equals("MANAGER")) {

                    shoeRepository.deleteById(Integer.parseInt(shoeId));

                    System.out.println("success");

                    response = new ResponseClass("100", "Shoe deleted successfully");

                } else {

                    System.out.println("is cashier");

                    response = new ResponseClass("101", "Sorry, you are not authorized to perform this action");

                }


            } else {

                response = new ResponseClass("103", "Sorry, you are not authorized to perform this action");

            }

            return response;

        } catch (Exception ex) {

            ex.printStackTrace();
            System.out.println("Get shoes exception: " + ex.getMessage());

            response = new ResponseClass("103", "Sorry, you are not authorized to perform this action");

            System.out.println("response: " + response.toString());

            return response;

        }
    }


}
