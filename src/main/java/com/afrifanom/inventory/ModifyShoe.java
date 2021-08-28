package com.afrifanom.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/shoes")
public class ModifyShoe {

    @Autowired
    ShoeRepository shoeRepository;


    @PutMapping(path = "/modify", produces = "application/json", consumes = "application/json")
    public ResponseClass modifyShoe(@RequestBody Shoe shoe) {

        ResponseClass response;

        try {

//            Shoe shoeResult = shoeRepository.findById(String.valueOf(shoe.getId()));
            Shoe shoeResult = shoeRepository.getOne((shoe.getId()));

            shoeResult.setBrand(shoe.getBrand());
            shoeResult.setSize(shoe.getSize());
            shoeResult.setPrice(shoe.getPrice());
            shoeResult.setColor(shoe.getColor());

            shoeRepository.save(shoeResult);

            response = new ResponseClass("100", "Shoe details modified successfully");


            return response;

        } catch (
                Exception ex) {

            ex.printStackTrace();
            System.out.println("Get shoes exception: " + ex.getMessage());

            response = new ResponseClass("103", "An error occurred");

            System.out.println("response: " + response.toString());

            return response;

        }
    }

}
