package com.afrifanom.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/shoes")
public class AddShoe {

    @Autowired
    ShoeRepository shoeRepository;

    @PostMapping(path = "/add", produces = "application/json", consumes = "application/json")
    public ResponseClass addShoe(@RequestBody Shoe shoe) {

        System.out.println("addShoe: " + shoe.toString());

        ResponseClass response;

        try {

            shoeRepository.save(shoe);

            response = new ResponseClass("100", "Shoes added successfully");

            return response;

        } catch (Exception ex) {

            ex.printStackTrace();
            System.out.println("Add shoes exception: " + ex.getMessage());

            response = new ResponseClass("101", "An error occurred in adding shoes");

            System.out.println("response: " + response.toString());

            return response;

        }

    }

}
